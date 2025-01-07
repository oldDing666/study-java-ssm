package com.afuya.study.spring01ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/7 21:12
 */
@Component
@Data
@PropertySource(value = "classpath:cat.properties")
public class Cat {

    /**
     * （1）@Value("字面值")：直接赋值
     * （2）@Value("${属性名}")：读取配置文件中的值
     * （3）@Value("#{表达式}")：SpEL
     */
    @Value("tom")
    private String name;
    @Value("${cat.color}")
    private String color;
    @Value("${cat.nickname:小花}")
    private String nickname;
    // 默认值：如果配置文件中没有对应的属性，则使用默认值
    @Value("${cat.address:北京}")
    private String address;
    @Value("#{2*3}")
    private Integer age;
    @Value("#{10>5}")
    private Boolean flag;
}
