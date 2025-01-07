package com.afuya.study.spring01ioc.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/7 21:12
 */
@Component
@Data
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
    @Value("#{2*3}")
    private Integer age;
    @Value("#{10>5}")
    private Boolean flag;
}
