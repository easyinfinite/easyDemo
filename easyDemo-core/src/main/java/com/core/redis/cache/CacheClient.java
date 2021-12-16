package com.core.redis.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.ShardedJedis;


@Slf4j
public class CacheClient {
    @Autowired
    private RedisDataSource redisDataSource;

    public void setRedisDataSource(RedisDataSource redisDataSource) {
        this.redisDataSource = redisDataSource;
    }


    public String demo() {
        String result = null;
        ShardedJedis jedis = null;
        boolean broken = false;
        try {
            jedis = redisDataSource.getRedisClient();
            result = jedis.set("11111","222222");
        } catch (Exception e) {
            log.error("2",e);
            broken = true;
        } finally {
            redisDataSource.returnResource(jedis, broken);
        }
        return result;
    }

    public String demo2() {
        String result = null;
        ShardedJedis jedis = null;
        boolean broken = false;
        try {
            jedis = redisDataSource.getRedisClient();
            result = jedis.get("11111");
        } catch (Exception e) {
            broken = true;
        } finally {
            redisDataSource.returnResource(jedis, broken);
        }
        return result;
    }
}
