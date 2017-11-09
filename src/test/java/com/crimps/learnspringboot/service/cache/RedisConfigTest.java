package com.crimps.learnspringboot.service.cache;

import com.crimps.learnspringboot.domain.UserEntity;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by crimps on 2017/11/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisConfigTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test() {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }

    @Test
    public void testObj() throws Exception{
        UserEntity userEntity = new UserEntity();
        userEntity.setId(UUID.randomUUID().toString());
        userEntity.setUsername("kk");
        userEntity.setEmail("kk@163.com");

        ValueOperations<String, UserEntity> operations = redisTemplate.opsForValue();
        operations.set("com.crimps.user1", userEntity);
        operations.set("com.crimps.user2", userEntity, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);

        boolean exists = redisTemplate.hasKey("com.crimps.user2");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
    }

}