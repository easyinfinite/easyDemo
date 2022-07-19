package com.mybatis.binding;

import com.mybatis.session.SqlSession;

import java.lang.reflect.Proxy;

/**
 * @ClassName:MapperProxyFactory
 * @Description 映射工厂类
 * @Author: chenyunxuan
 * @Date: 2022/7/18 2:12 PM
 * @version: 1.0.0
 **/
public class MapperProxyFactory<T> {
    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public T newInstance(SqlSession sqlSession) {
        final MapperProxy<T> mapperProxy = new MapperProxy<>(sqlSession, mapperInterface);
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }
}
