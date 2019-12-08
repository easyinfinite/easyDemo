package com.redis;

import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RList;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @ClassName:RedissonTest
 * @Description 测试类
 * @Author: chenyunxuan
 * @Date: 2019-12-08 16:55
 * @version: 1.0.0
 **/
@SpringBootTest
@RunWith(SpringRunner.class)
@Component
@ContextConfiguration
@Log4j2
public class BaseTest {
    @Autowired(required = false)
    private RedissonClient redissonClient;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void set() throws InterruptedException {
        // 设置字符串
        RBucket<String> keyObj = redissonClient.getBucket("k1");
        keyObj.set("v1236");
        // 设置int
        RBucket<Integer> keyObj1 = redissonClient.getBucket("k2");
        keyObj1.set(231234);
        //设置lisr
        RList<String> s = redissonClient.getList("k3");
        s.add("12312");
        s.add("1233");
        //设置map
        RMap<String, RList> ss = redissonClient.getMap("k4");
        ss.put("hahaha", s);
        ss.put("111", s);

        //与RedisTemplate可以共用
        stringRedisTemplate.opsForValue().set("yunai1111", "shuai");
    }
}
