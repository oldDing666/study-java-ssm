package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:32
 */
@Configuration
public class DogConfig {

    @Bean
    public Dog dog() {
        return new Dog();
    }
}
