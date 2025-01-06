package com.afuya.study.spring01ioc.repository;

import com.afuya.study.spring01ioc.bean.Dog;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:49
 */
@Repository
@Data
public class UserDao {

    Dog dog;

    // Spring更推荐使用构造器注入
//    public UserDao(Dog dog) {
//        this.dog = dog;
//    }

    // setter方法注入
    @Autowired
    public void setDog(Dog dog) {
        this.dog = dog;
    }
}
