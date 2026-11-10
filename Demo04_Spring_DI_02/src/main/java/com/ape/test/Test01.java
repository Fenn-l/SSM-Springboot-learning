package com.ape.test;

import com.ape.controller.IUserController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01 {
    public static void main(String[] args) {
        //1.获取容器对象
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.获取contorller
        IUserController controller = (IUserController) applicationContext.getBean("controllerImp");
        controller.saveUser();
    }
}
