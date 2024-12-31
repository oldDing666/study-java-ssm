package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.bean.Dog;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:32
 */
@Configuration
public class DogConfig {

    /**
     * （1）@Scope("prototype") 非单例：
     * 每次从容器中获取对象，都会创建一个新的实例；
     * 容器启动的过程中不会创建组件的实例对象，什么时候获取，什么时候创建
     * （2）@Scope("singleton") 单例：
     * 在整个应用程序中只创建一个实例；
     * 容器启动的过程中会创建组件的实例对象，容器启动完成前就会创建好
     * （3）@Scope("request") 请求：
     * 每次HTTP请求都会创建一个新的实例；
     * （4）@Scope("session") 会话：
     * 每次HTTP会话都会创建一个新的实例；
     *
     * @return
     */
    @Bean
    @Scope("singleton")
//    @Scope("prototype")
    public Dog dog() {
        return new Dog();
    }
}
