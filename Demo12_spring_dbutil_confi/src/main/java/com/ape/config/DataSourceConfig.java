package com.ape.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

@Configuration
@PropertySource("classpath:jdbc.properties")
public class DataSourceConfig {
    @Value("${msg1}")
    private String msg1;
    @Value("${msg2}")
    private String msg2;
    @Value("${msg3}")
    private String msg3;
    @Value("${msg4}")
    private String msg4;
    @Bean
    public DataSource dataSource() {
        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
        try {
            comboPooledDataSource.setDriverClass(msg1);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        comboPooledDataSource.setJdbcUrl(msg2);
        comboPooledDataSource.setUser(msg3);
        comboPooledDataSource.setPassword(msg4);
        return comboPooledDataSource;
    }
    @Bean
    public QueryRunner queryRunner(){
        return new QueryRunner(dataSource());
    }
}
