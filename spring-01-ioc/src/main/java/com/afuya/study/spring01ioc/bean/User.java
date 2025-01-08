package com.afuya.study.spring01ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/8 23:20
 */
@Data
public class User {
    private String userName;
    private String password;

    Dog dog;

    @Autowired
    public void setter(Dog dog) {
        this.dog = dog;
        System.out.println("dog setter方法 执行了...");
    }

    public User() {
        System.out.println("User的无参构造方法 执行了...");
    }

    private void init() {
        System.out.println("init方法 执行了...");
    }

    private void destroy() {
        System.out.println("destroy方法 执行了...");
    }
}
