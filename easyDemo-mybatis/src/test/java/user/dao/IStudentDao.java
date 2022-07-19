package user.dao;

/**
 * @ClassName:IUserDao
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/18 11:25 AM
 * @version: 1.0.0
 **/
public interface IStudentDao {

    /**
     * 查询用户名称
     *
     * @author: chenyunxuan
     * @updateTime: 2022/7/18 11:25 AM
     */
    public String selectUserName(String id);

    /**
     * 查询用户密码
     *
     * @author: chenyunxuan
     * @updateTime: 2022/7/18 11:25 AM
     */
    public String selectPassword(String id);
}
