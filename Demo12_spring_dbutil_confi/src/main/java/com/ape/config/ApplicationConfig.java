package com.ape.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = "com.ape")
@Import({DataSourceConfig.class})
public class ApplicationConfig {

}
