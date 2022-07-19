package com.mybatis.session.defaults;

import com.mybatis.binding.MapperRegistry;
import com.mybatis.session.SqlSession;
import com.mybatis.session.SqlSessionFactory;

/**
 * @ClassName:DefaultSqlSessionFactory
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/19 9:49 AM
 * @version: 1.0.0
 **/
public class DefaultSqlSessionFactory implements SqlSessionFactory {
    private final MapperRegistry mapperRegistry;

    public DefaultSqlSessionFactory(MapperRegistry mapperRegistry) {
        this.mapperRegistry = mapperRegistry;
    }

    @Override
    public SqlSession openSession() {
        return new DefaultSqlSession(mapperRegistry);
    }
}
