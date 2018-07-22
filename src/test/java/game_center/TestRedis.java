package game_center;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @user ming.yang
 * @date 2016年6月1日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
@Transactional
public class TestRedis {
	@Autowired
	private RedisTemplate<String, String> jedisTemplate;
	@Test
	public void set(){
		ValueOperations<String, String> valueOpts = jedisTemplate.opsForValue();
		valueOpts.set("woooo", "1ddd");
	}
}
