package com.ape.springboot_data_mybatis_03;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ape.springboot_data_mybatis_03.mapper")
public class SpringbootDataMybatis03Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataMybatis03Application.class, args);
    }

}
