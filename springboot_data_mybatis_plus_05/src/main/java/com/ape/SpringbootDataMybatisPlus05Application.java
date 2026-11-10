package com.ape;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement   //开启事务
@EnableAsync                  //开启基于注解的异步任务
@EnableScheduling             //开启基于注解的定时任务
public class SpringbootDataMybatisPlus05Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataMybatisPlus05Application.class, args);
    }

}