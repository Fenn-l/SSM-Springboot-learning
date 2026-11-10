package com.ape.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.ape")
@PropertySource("classpath:message.properties")
@Import(DataSourceConfig.class)
public class ApplicationConfig {
}
