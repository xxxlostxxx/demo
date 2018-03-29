package com.example.demo;

import com.lst.service.DemoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
@Autowired
private DemoService demoService;
	@Autowired
	JedisPool jedisPool;
	@Test
	public void contextLoads() {

		String demo = demoService.demo();
		System.out.println(demo);
	}
	@Test
	public void testJedis() {

		String uuid = UUID.randomUUID().toString();
		Jedis jedis = jedisPool.getResource();
		jedis.setex("ssssssss", 1000, uuid);
	}
}
