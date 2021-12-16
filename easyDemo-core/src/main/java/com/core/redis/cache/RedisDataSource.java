package com.core.redis.cache;


import lombok.extern.slf4j.Slf4j;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

@Slf4j
public class RedisDataSource {
    private ShardedJedisPool shardedJedisPool;

    public ShardedJedisPool getShardedJedisPool() {
        return shardedJedisPool;
    }

    public void setShardedJedisPool(ShardedJedisPool shardedJedisPool) {
        this.shardedJedisPool = shardedJedisPool;
    }

    public ShardedJedis getRedisClient() {
        try {
            ShardedJedis shardJedis = shardedJedisPool.getResource();
            return shardJedis;
        } catch (Exception e) {
            log.error("error {}",e);
        }
        return null;
    }

    public void returnResource(ShardedJedis shardedJedis) {
        returnResource(shardedJedis, false);
    }

    public void returnResource(ShardedJedis shardedJedis, boolean broken) {
        try {
            if (shardedJedisPool != null) {
                if (broken) {
                    shardedJedisPool.returnBrokenResource(shardedJedis);
                } else {
                    shardedJedisPool.returnResource(shardedJedis);
                }
            }
        } catch (Exception ex) {
            shardedJedisPool.returnBrokenResource(shardedJedis);
        }
    }
}
