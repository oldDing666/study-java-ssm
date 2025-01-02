package com.afuya.study.spring01ioc.config;

import com.afuya.study.spring01ioc.condition.MacCondition;
import com.afuya.study.spring01ioc.condition.WindowsCondition;
import com.afuya.study.spring01ioc.bean.Person;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:32
 */

//@Conditional(MacCondition.class)
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

    @Bean("jobs")
    @Conditional(MacCondition.class)
    public Person person003() {
        Person person = new Person();
        person.setName("jobs");
        return person;
    }

    @Conditional(WindowsCondition.class)
    @Bean("billGates")
    public Person person002() {
        Person person = new Person();
        person.setName("billGates");
        return person;
    }
}
