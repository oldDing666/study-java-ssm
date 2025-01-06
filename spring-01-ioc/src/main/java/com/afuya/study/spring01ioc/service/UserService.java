package com.afuya.study.spring01ioc.service;

import com.afuya.study.spring01ioc.bean.Dog;
import com.afuya.study.spring01ioc.bean.Person;
import jakarta.annotation.Resource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:49
 */
@Service
@Data
public class UserService {

//    @Qualifier("person001")
    @Autowired
//    Person person001;
    Person person;

    // @Autowired 和 @Resources 的区别
    // （1）@Autowired 是 Spring 提供的注解，用于依赖注入。
    // @Resource 是 Java 标准规范(jakarta)中的注解，用于依赖注入。
    // （2）@Autowired 可以指定通过类型或者名称进行匹配的 bean 进行注入。
    // @Resource 主要通过名称进行匹配，如果没有提供名称，则会回退到类型匹配。
    // （3）@Autowired 支持可选依赖，可以通过设置 required 属性为 false 来实现。
    // @Resource 不支持可选依赖，如果没有找到匹配的 bean 会抛出异常。
    @Resource
    Dog dog;
}
