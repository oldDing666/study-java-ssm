package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.datasource.MyDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/7 23:04
 */
@Configuration
public class DataSourceConfig {

    @Profile({"dev", "default"})
    @Bean
    public MyDataSource dev() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/dev");
        dataSource.setUsername("dev");
        dataSource.setPassword("dev_pwd");
        return dataSource;
    }

    @Profile("prod")
    @Bean
    public MyDataSource prod() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/prod");
        dataSource.setUsername("prod");
        dataSource.setPassword("prod_pwd");
        return dataSource;
    }

    @Profile("test")
    @Bean
    public MyDataSource test() {
        MyDataSource dataSource = new MyDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("test");
        dataSource.setPassword("test_pwd");
        return dataSource;
    }

}
