package com.ape.test;

import com.ape.bean.Account;
import com.ape.config.ApplicationConfig;
import com.ape.controller.IController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        IController controller =(IController) context.getBean("controllerImp");
//        controller.saveAccount(new Account("夏深",10000));
//        controller.saveAccount(new Account("魏新雨",10000));

        List<Account> account = controller.findAccount();
        for (int i = 0; i < account.size(); i++) {
            Account account1 =  account.get(i);
            System.out.println(account1);
        }

    }
}
