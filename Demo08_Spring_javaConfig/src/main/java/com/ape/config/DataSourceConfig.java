package com.ape.config;

import com.ape.bean.School;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class DataSourceConfig {
    //注入系统类
    @Bean
    public Date date(){
        return new Date();
    }

    //注入自定义类
    @Bean(name = "sh")
    public School school(){
        return new School();
    }
}
