package com.ape.springboot_data_mybatis_04;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.ape.springboot_data_mybatis_04.mapper")
public class SpringbootDataMybatis04Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataMybatis04Application.class, args);
    }
}
