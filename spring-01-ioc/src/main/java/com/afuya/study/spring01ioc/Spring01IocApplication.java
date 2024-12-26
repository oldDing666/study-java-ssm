package com.afuya.study.spring01ioc;

import com.afuya.study.spring01ioc.bean.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        // 这个接口继承于ApplicationContext接口，这个就是ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println(ioc);
        // 获取ioc容器中所有的组件(bean)的名称
        String[] beans = ioc.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }
    }

    // 给容器中注册一个组件，这个组件默认的id就是方法名首字母小写
    @Bean
    public Person person007(){
        Person person = new Person();
        person.setName("张三");
        person.setAge(18);
        person.setAddress("北京朝阳区");
        return person;
    }

}
