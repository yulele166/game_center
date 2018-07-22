package com.qn.gamecenter.interceptor;

import java.net.URLDecoder;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import net.paoding.rose.web.ControllerInterceptorAdapter;
import net.paoding.rose.web.Invocation;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.peanut.commons.utils.CollectionUtil;
import com.qn.gamecenter.ano.RequestMap;
import com.qn.gamecenter.bean.RequestMessage;
import com.qn.gamecenter.bean.ResponseMessage;
import com.qn.gamecenter.bean.message.req.DeaultRequestReq;
import com.qn.gamecenter.service.MessageService;
import com.qn.gamecenter.service.UserService;
import com.qn.gamecenter.util.ClassUtil;

/**
 * 将所有客户端请求转换成bean的拦截器
 * 
 * @author
 * @since 2015年11月20日 下午6:42:34
 */
@SuppressWarnings({ "rawtypes", "unchecked" })
@Component
public class MessageInterceptor extends ControllerInterceptorAdapter {

	private final static Logger LOG = LoggerFactory
			.getLogger(MessageInterceptor.class);
	
	private static Map<String, Class<? extends RequestMessage>> messageBean = CollectionUtil.hashMap();

	@Autowired
	private MessageService messageService;

	@Autowired
	private UserService userService;
	static {
		List<Class> classes;
		try {
			classes = ClassUtil.getAllClassByInterface(Class
					.forName("com.qn.gamecenter.bean.RequestMessage"));
			for (Class clas : classes) {
				Object obj = clas.getAnnotation(RequestMap.class);
				if(obj == null){
					continue;
				}
				RequestMap ano =(RequestMap)obj;
				String methods = ano.value();
				if(methods.contains(",")){
					String[] methodStrs = methods.split(",");
					for (String method : methodStrs) {
						messageBean.put(method.toLowerCase(), clas);
					}
				}else{
					messageBean.put(methods.toLowerCase(), clas);
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}


	@Override
	protected Object before(Invocation inv) throws Exception {
		HttpServletRequest request = inv.getRequest();
		String data = (String) request.getParameter("data");// 默认的参数名称
		if(StringUtils.isNotBlank(data)){
			data = URLDecoder.decode(data, "UTF-8");
		}

		ResponseMessage reponseMessage = new ResponseMessage();
		// 开始时间
		long beginTime = System.currentTimeMillis();
		
		// 访问uri
		String requestURI = request.getRequestURI();
		String methodName = inv.getMethod().getName().toLowerCase();
		
		String ip = messageService.getIpAddress(request);
		LOG.info("request {},ip:{},params:{},method:{}", requestURI, ip, data,methodName);
		inv.setAttribute("begin", beginTime);
		Class<? extends RequestMessage> paramClass ;
		RequestMessage obj;
		if(messageBean.containsKey(methodName)){
			paramClass = messageBean.get(methodName);
			obj = JSON.parseObject(data, paramClass);
			//改变调用方法参数
			inv.changeMethodParameter(0, obj);
			LOG.info("add act user {}" ,obj.getBaseInfo());
			LOG.info("add user active {}",obj.getBaseInfo());
			//用户行为
			userService.addUserActive(methodName, obj, obj.getBaseInfo());
			//活跃
			userService.addActUser(obj.getBaseInfo(),methodName);
		}else{
			paramClass = DeaultRequestReq.class;
			obj = JSON.parseObject(data, paramClass);
			//用户行为
			userService.addUserActive(methodName, obj, obj.getBaseInfo());
		}
		inv.setAttribute("message", obj);
		inv.setAttribute("result", reponseMessage);
		return super.before(inv);
	}
	
	
	@Override
	protected Object after(Invocation inv, Object instruction) throws Exception {
		ResponseMessage message = messageService.getRepMessage(inv);
		message.setData(instruction);
		inv.getResponse().setContentType("text/html;charset=UTF-8");
		String result = "@" + JSON.toJSONString(message);
		String requestURI = inv.getRequest().getRequestURI();
		long begin = (Long) inv.getAttribute("begin");
		// 请求耗时
		long timeconsume = System.currentTimeMillis() - begin;
		LOG.info("{} result:{},cost:[{}ms]", requestURI, result, timeconsume);
		inv.getResponse().setHeader("Access-Control-Allow-Origin", "*");
		return super.after(inv, result);
	}

}
