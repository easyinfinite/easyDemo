package com.core.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * redis参数配置类
 *
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2021/5/19 7:35 下午
 * @version: 1.0.0
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisParam {
    private String host;
    private int port;
    private int timeout;
    private String password;
    private int database;
}
