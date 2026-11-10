package com.ape.test;

import com.ape.bean.Student;
import com.ape.bean.Teacher;
import com.ape.config.ApplicationConfig;
import com.ape.controller.IUserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        //1.获取容器对象
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ApplicationConfig.class);
//        Student student  =  (Student) applicationContext.getBean("student");
//        System.out.println(student);
//
        Teacher teacher  =  (Teacher) applicationContext.getBean("th");
        System.out.println(teacher);

//        IUserController controller = (IUserController) applicationContext.getBean("userControllerImp");
//        controller.saveUser();
    }
}
