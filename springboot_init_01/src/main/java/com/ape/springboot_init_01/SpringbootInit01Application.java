package com.ape.springboot_init_01;

import com.ape.springboot_init_01.bean.Dog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SpringbootInit01Application {

    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext= SpringApplication.run(SpringbootInit01Application.class, args);
        Dog dog=(Dog) applicationContext.getBean("dog");
        System.out.println(dog);
    }

}
