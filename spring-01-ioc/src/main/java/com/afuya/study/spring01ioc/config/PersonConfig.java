package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:32
 */

@Configuration
public class PersonConfig {

    // 给容器中注册一个组件，这个组件默认的id就是方法名首字母小写
    @Bean("person008")
    public Person person007() {
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        person.setAddress("北京朝阳区");
        return person;
    }

    @Bean
    public Person person001() {
        Person person = new Person();
        person.setName("lisi");
        person.setAge(20);
        person.setAddress("上海浦东区");
        return person;
    }
}
