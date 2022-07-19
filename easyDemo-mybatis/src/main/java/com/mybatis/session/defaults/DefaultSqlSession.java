package com.mybatis.session.defaults;

import com.mybatis.binding.MapperRegistry;
import com.mybatis.session.SqlSession;

/**
 * @ClassName:DefaultSqlSession
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/19 9:45 AM
 * @version: 1.0.0
 **/
public class DefaultSqlSession implements SqlSession {
    private MapperRegistry mapperRegistry;

    public DefaultSqlSession(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public <T> T selectOne(String statement) {
        return null;
    }

    @Override
    public <T> T selectOne(String statement, Object parameter) {
        return (T) ("你被代理了！" + "方法：" + statement + " 入参：" + parameter);
    }

    @Override
    public <T> T getMapper(Class<T> type) {
        return mapperRegistry.getMapper(type, this);
    }
}
