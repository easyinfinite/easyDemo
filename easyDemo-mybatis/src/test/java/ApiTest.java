import com.mybatis.bind.MapperProxyFactory;
import com.mybatis.dao.IUserDao;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.lang.reflect.Proxy;
import java.util.HashMap;
import java.util.Map;


/**
 * @ClassName:ApiTest
 * @Description //TODO
 * @Author: chenyunxuan
 * @Date: 2022/7/18 11:26 AM
 * @version: 1.0.0
 **/
@Log4j2
public class ApiTest {

    @Test
    public void Test() {
        IUserDao iUserDao = (IUserDao) Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class[]{IUserDao.class},
                (a, b, c) -> "我被代理了");
        String s = iUserDao.selectUserName();
        System.out.println(s);
    }

    @Test
    public void Test1() {
        MapperProxyFactory<IUserDao> factory = new MapperProxyFactory<>(IUserDao.class);
        Map<String, String> sqlSession = new HashMap<>();

        sqlSession.put("com.mybatis.dao.IUserDao.selectUserName", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户姓名");
        sqlSession.put("com.mybatis.dao.IUserDao.selectPassword", "模拟执行 Mapper.xml 中 SQL 语句的操作：查询用户年龄");
        IUserDao userDao = factory.newInstance(sqlSession);

        String res = userDao.selectUserName();
        log.info("测试结果：{}", res);
    }
}
