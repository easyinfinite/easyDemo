package com.mybatis.dao;

/**
 * @ClassName:IUserDao
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/18 11:25 AM
 * @version: 1.0.0
 **/
public interface IUserDao {

    /**
     * 查询用户名称
     *
     * @author: chenyunxuan
     * @updateTime: 2022/7/18 11:25 AM
     */
    public String selectUserName();

    /**
     * 查询用户密码
     *
     * @author: chenyunxuan
     * @updateTime: 2022/7/18 11:25 AM
     */
    public String selectPassword();
}
