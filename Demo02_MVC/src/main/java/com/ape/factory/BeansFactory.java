package com.ape.factory;

import com.ape.controller.UserControllerImp;
import com.ape.service.IUserService;

import java.io.InputStream;
import java.util.Properties;

public class BeansFactory {


    //按照用户需求进行javaBean对象创建
    public static Object getBean(String key) {
        try {
            //1.创建工具类
            Properties properties = new Properties();
            //2.加载properties资源文件
            InputStream stream = BeansFactory.class.getClassLoader().getResourceAsStream("beans.properties");
            properties.load(stream);
            //3.通过用户传递的key获取对应的value数据
            String classPath = properties.getProperty(key);
            //4.反射实例化对象
            return Class.forName(classPath).newInstance();
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
