package com.mybatis.binding;

import com.mybatis.session.SqlSession;

import java.io.Serializable;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName:MapperProxy
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/18 10:51 AM
 * @version: 1.0.0
 **/
public class MapperProxy<T> implements InvocationHandler, Serializable {
    private static final long serialVersionUID = -8768698179375406091L;

    private SqlSession sqlSession;
    private final Class<T> mapperInterface;

    public MapperProxy(SqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (Object.class.equals(method.getDeclaringClass())) {
            return method.invoke(proxy, method, args);
        }else{
            return sqlSession.selectOne(method.getName(), args);
        }
    }

}
