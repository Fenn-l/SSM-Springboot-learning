package com.ape.test;

import com.ape.bean.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class test {
    public static void main(String[] args) {
        //1.加载spring主配置文件获取ioc容器
        BeanFactory applicationContext = new ClassPathXmlApplicationContext("beans.xml");
        //2.获取javaBean实例
        Student student = (Student) applicationContext.getBean("student");
        Date date = (Date) applicationContext.getBean("date");
        System.out.println(date);
        System.out.println(student);
    }
}
