package com.ape.springboot_data_mybatis_02;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.ape.springboot_data_mybatis_02.mapper")
public class SpringbootDataMybatis02Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDataMybatis02Application.class, args);
    }

}
