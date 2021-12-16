package com.core.redis.config;

import com.core.redis.cache.CacheClient;
import com.core.redis.cache.RedisDataSource;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName:RedisConfig
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2021/5/19 7:16 下午
 * @version: 1.0.0
 **/
@Configuration
public class RedisConfig {
    @Autowired
    RedisParam redisParam;

    @Bean
    public JedisShardInfo jedisShardInfo() {
        JedisShardInfo jedisShardInfo= new JedisShardInfo(redisParam.getHost(), redisParam.getPort(), redisParam.getPassword());
        jedisShardInfo.setPassword(redisParam.getPassword());
        return jedisShardInfo;
    }

    @Bean
    @ConfigurationProperties(prefix = "spring.redis.jedis.pool")
    public GenericObjectPoolConfig<ShardedJedis> jedisPoolConfig() {
        return new GenericObjectPoolConfig<>();
    }

    @Bean
    public ShardedJedisPool shardedJedisPool(GenericObjectPoolConfig<ShardedJedis> jedisPoolConfig, JedisShardInfo jedisShardInfo) {
        List<JedisShardInfo> shards = new ArrayList<>();
        shards.add(jedisShardInfo);
        return new ShardedJedisPool(jedisPoolConfig, shards);
    }

    // 自定义缓存
    @Bean
    public RedisDataSource redisDataSource(ShardedJedisPool shardedJedisPool) {
        RedisDataSource redisDataSource = new RedisDataSource();
        redisDataSource.setShardedJedisPool(shardedJedisPool);
        return redisDataSource;
    }

    @Bean
    public CacheClient cacheClient(RedisDataSource redisDataSource) {
        CacheClient redisClient = new CacheClient();
        redisClient.setRedisDataSource(redisDataSource);
        return redisClient;
    }
}
