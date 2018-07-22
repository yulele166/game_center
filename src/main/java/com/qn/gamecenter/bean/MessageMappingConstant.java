package com.qn.gamecenter.bean;

import java.util.Map;

import com.peanut.commons.utils.CollectionUtil;

/**
 * 方法与消息模型的映射
 * 
 * @author 
 * @since 2015年11月24日 下午3:14:23
 */
public class MessageMappingConstant {
	private static Map<String, Class<? extends RequestMessage>> MESSAGE_MAPS = CollectionUtil.hashMap();

	static {
		
		MESSAGE_MAPS.put("getallad", RequestMessage.class);
	}

	/**
	 * 获取访问方法的参数类型
	 * 
	 * @param methodName
	 * @return {@link RequestMessage}
	 */
	public static Class<? extends RequestMessage> getMessageType(String methodName) {
		String lowMethodName = methodName.toLowerCase();
		if (MESSAGE_MAPS.containsKey(lowMethodName)) {
			return MESSAGE_MAPS.get(lowMethodName);
		}
		return null;
	}
}
