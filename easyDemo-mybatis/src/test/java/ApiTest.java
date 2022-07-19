import com.mybatis.binding.MapperRegistry;
import business.dao.IUserDao;
import com.mybatis.session.SqlSession;
import com.mybatis.session.SqlSessionFactory;
import com.mybatis.session.defaults.DefaultSqlSessionFactory;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;

import java.lang.reflect.Proxy;


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
        String s = iUserDao.selectUserName("1");
        System.out.println(s);
    }

    @Test
    public void Test1() {
        //注册
        MapperRegistry registry = new MapperRegistry();
        registry.addMappers("business.dao");
        // 2. 从 SqlSession 工厂获取 Session
        SqlSessionFactory sqlSessionFactory = new DefaultSqlSessionFactory(registry);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 3. 获取映射器对象
        IUserDao userDao = sqlSession.getMapper(IUserDao.class);
        // 4. 测试验证
        String res = userDao.selectUserName("111");
        log.info("测试结果：{}", res);
    }
}
