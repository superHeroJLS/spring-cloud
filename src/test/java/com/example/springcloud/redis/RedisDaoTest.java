package com.example.springcloud.redis;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisDaoTest {

    @Autowired
    private RedisDao redisDao;

    @Test
    public void testRedis() {
        redisDao.setKey("name", "redis");
        redisDao.setKey("age", "22");
        Assert.assertEquals("redis", redisDao.getValue("name"));
        Assert.assertEquals("22", redisDao.getValue("age"));
    }
}
