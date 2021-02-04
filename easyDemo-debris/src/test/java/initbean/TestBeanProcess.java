package initbean;

import com.debris.initbean.SysConfig;
import org.junit.After;
import org.junit.Test;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @ClassName: TestBeanProcess
 * @Description 测试bean的初始化与销毁
 * @Author: chenyunxuan
 * @Date: 2021/2/4 10:45 上午
 * @version: 1.0.0
 **/
public class TestBeanProcess {
    // 使用容器
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SysConfig.class);

    @Test
    public void contextTest() {
        // 测试Bean的三种初始化、销毁方式和执行顺序
        System.out.println(context.getBean(InitializingBean.class));
    }

    @After
    public void closeContext() {
        context.close();
    }
}