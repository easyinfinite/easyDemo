package com.mybatis.session;

/**
 * @ClassName:SqlSessionFactory
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/19 9:48 AM
 * @version: 1.0.0
 **/
public interface SqlSessionFactory {
    /**
     * 打开一个 session
     * @return SqlSession
     */
    SqlSession openSession();
}
