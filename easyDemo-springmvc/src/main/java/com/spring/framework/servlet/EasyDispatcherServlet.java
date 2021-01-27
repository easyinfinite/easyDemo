package com.spring.framework.servlet;

import com.spring.framework.annotation.DemoAutowired;
import com.spring.framework.annotation.DemoController;
import com.spring.framework.annotation.DemoRequestMapping;
import com.spring.framework.annotation.DemoService;
import lombok.extern.java.Log;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.*;

/**
 * @ClassName: EasyDispatcherServlet
 * @Description //核心处理类
 * @Author: chenyunxuan
 * @Date: 2021/1/27 10:04 上午
 * @version: 1.0.0
 **/
@Log
public class EasyDispatcherServlet extends HttpServlet {

    /**
     * @description: 初始化ios容器
     * @author: chenyunxuan
     * @updateTime: 2021/1/27 10:20 上午
     */
    private Map<String, Object> ioc = new HashMap<>();
    /**
     * @description: 保存配置文件
     * @author: chenyunxuan
     * @updateTime: 2021/1/27 10:21 上午
     */
    private Properties contextConfig = new Properties();

    /**
     * @description: 保存扫描到的类完整包路径
     * @author: chenyunxuan
     * @updateTime: 2021/1/27 11:21 上午
     */
    private List<String> classNames = new ArrayList<>();

    /**
     * @description: 路由路径和method之间的关系容器
     * @author: chenyunxuan
     * @updateTime: 2021/1/27 3:23 下午
     */
    private Map<String, Method> mappingHandler = new HashMap<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doSomething(req,resp);
    }

    private void doSomething(HttpServletRequest req, HttpServletResponse resp) {
        log.info(req.getRequestURI()+"xxxxxxxxxxxxxx");
        log.info(req.getRequestURI()+"xxxxxxxxxxxxxx");
        log.info(req.getRequestURI()+"xxxxxxxxxxxxxx");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        //1.加载配置文件
        doLoadConfig(config.getInitParameter("contextConfigLocation"));
        //2.扫描相关类
        doScanner(contextConfig.getProperty("scanPackage"));
        //3.实例化相关类,缓存到ioc容器中
        doInstance();
        //4.DI,完成依赖注入
        doAutowired();
        //5.初始化handMapping,完成url与menthod的映射
        doInitHandlerMapping();

        log.info("easySpringMvc int success");
    }

    private void doInitHandlerMapping() {
        if (ioc.isEmpty()) return;
        ioc.forEach((key, value) -> {
            Class<?> clazz = value.getClass();
            if (!clazz.isAnnotationPresent(DemoController.class)) return;
            //找出类上的mapping注解,用作baseUrl
            String baseUrl = "";
            if (clazz.isAnnotationPresent(DemoRequestMapping.class)) {
                DemoRequestMapping demoRequestMapping = clazz.getAnnotation(DemoRequestMapping.class);
                baseUrl = demoRequestMapping.value();
            }
            String finalBaseUrl = baseUrl;
            Arrays.stream(clazz.getMethods()).forEach(item -> {
                if (!item.isAnnotationPresent(DemoRequestMapping.class)) return;
                DemoRequestMapping demoRequestMapping = item.getAnnotation(DemoRequestMapping.class);
                String url = demoRequestMapping.value();
                StringJoiner stringJoiner = new StringJoiner("/");
                stringJoiner.add(finalBaseUrl);
                stringJoiner.add(url);
                mappingHandler.put(stringJoiner.toString().replace("/+", "/"), item);
                log.info("url:+" + url + " ---->" + item);
            });
        });
    }

    private void doAutowired() {
        if (ioc.isEmpty()) return;
        ioc.forEach((key, value) -> {
            //取出ioc容器中所有的实现类字段
            Field[] field = value.getClass().getDeclaredFields();
            Arrays.stream(field).forEach(item -> {
                //如果是注入注解,就需要把ioc实例注解进去
                if (!item.isAnnotationPresent(DemoAutowired.class)) return;
                DemoAutowired autowired = item.getAnnotation(DemoAutowired.class);
                String beanName = autowired.value().trim();
                if ("".equals(beanName)) {
                    beanName = item.getType().getName();
                }
                //解除限制
                item.setAccessible(Boolean.TRUE);
                try {
                    //反射注入字段ioc容器中的对象
                    item.set(value, ioc.get(beanName));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        });
    }

    private void doInstance() {
        try {
            for (String className : classNames) {
                Class clazz = Class.forName(className);
                String beanName = toLowerFirstCase(clazz.getSimpleName());
                if (clazz.isAnnotationPresent(DemoController.class)) {
                    Object object = clazz.newInstance();
                    ioc.put(beanName, object);
                } else if (clazz.isAnnotationPresent(DemoService.class)) {
                    //1.不同包下的相同名字取别名
                    DemoService demoService = (DemoService) clazz.getAnnotation(DemoService.class);
                    if (!"".equals(demoService.value())) {
                        beanName = demoService.value();
                    }
                    Object object = clazz.newInstance();
                    ioc.put(beanName, object);
                    //2.如果是接口,把接口的实现类给他
                    for (Class i : clazz.getInterfaces()) {
                        //如果一个接口被多个接口实现类实现,需要取别名的方式@Qualifier
                        if (ioc.containsKey(i.getName())) {
                            ioc.put(i.getName(), object);
                        }
                        ioc.put(i.getName(), object);
                    }
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * @description: 首字母小写
     * @author: chenyunxuan
     * @updateTime: 2021/1/27 11:33 上午
     */
    private String toLowerFirstCase(String simpleName) {
        char[] chars = simpleName.toCharArray();
        //大小写ASCII码转换
        chars[0] += 32;
        return String.valueOf(chars);
    }

    private void doScanner(String scanPackage) {
        //获取扫描路径
        String path = "/" + scanPackage.replace(".", "/");
        URL url = this.getClass().getClassLoader().getResource(path);
        if (url != null) {
            File classPath = new File(url.getFile());
            for (File file : classPath.listFiles()) {
                String fileName = file.getName();
                //如果是一个文件夹的话就需要递归到下一层
                if (file.isDirectory()) {
                    doScanner(scanPackage + "." + fileName);
                } else {
                    //不是的话就拼装群类名追加到后面
                    if (!fileName.endsWith(".class")) continue;
                    String className = scanPackage + "." + file.getName().replace(".class", "");
                    classNames.add(className);
                }
            }
        }
    }

    private void doLoadConfig(String contextConfigLocation) {
        URL url = Thread.currentThread().getContextClassLoader().getResource(contextConfigLocation);
        InputStream is = this.getClass().getClassLoader().getResourceAsStream(contextConfigLocation);
        try {
            contextConfig.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
