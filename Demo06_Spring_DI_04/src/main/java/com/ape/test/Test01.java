package com.ape.test;

import com.ape.bean.Dog;
import com.ape.bean.School;
import com.ape.bean.Student;
import com.ape.bean.Teacher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        //1.获取容器对象
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Dog dog  =  (Dog)applicationContext.getBean("dog");
        System.out.println(dog);
        applicationContext.close();//关闭容器，他会回收单例创建的javaBean
//        Student student1 = (Student) applicationContext.getBean("student");
//        Student student2 = (Student) applicationContext.getBean("student");
//        System.out.println(student1==student2);

//        Teacher teacher = (Teacher) applicationContext.getBean("teacher");
//        System.out.println(teacher);

//        School school = (School) applicationContext.getBean("school");
//        System.out.println(school);
    }
}
