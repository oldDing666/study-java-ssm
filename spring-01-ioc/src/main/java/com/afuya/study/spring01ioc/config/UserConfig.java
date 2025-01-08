package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/8 23:20
 */
@Configuration
public class UserConfig {

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public User user(){
        return new User();
    }

}
