package com.afuya.study.spring01ioc;

import com.afuya.study.spring01ioc.bean.Dog;
import com.afuya.study.spring01ioc.bean.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

@SpringBootApplication
public class Spring01IocApplication {

    /**
     * （1）ioc容器创建过程中，就会创建组件
     * （2）创建的组件默认是单实例的，每次获取组件都是从容器中获取
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("===========创建容器前=============");
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("===========创建容器后=============");

        Dog bean = ioc.getBean(Dog.class);
        System.out.println("bean = " + bean);

        Dog bean2 = ioc.getBean(Dog.class);
        System.out.println("bean2 = " + bean2);

        Dog bean3 = ioc.getBean(Dog.class);
        System.out.println("bean3 = " + bean3);
    }

    public static void fun1(String[] args) {
        // 这个接口继承于ApplicationContext接口，这个就是ioc容器
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println(ioc);
        // 获取ioc容器中所有的组件(bean)的名称
        String[] beans = ioc.getBeanDefinitionNames();
        for (String bean : beans) {
            System.out.println(bean);
        }

        System.out.println("========================");
        // 1 按组件名字称获取组件
        Object person007 = ioc.getBean("person008");
        System.out.println(person007);

        // 2 按类型获取单个组件
        Dog dog = ioc.getBean(Dog.class);
        System.out.println(dog);

        // 3 按类型获取所有组件
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        for (Map.Entry<String, Person> entry : beansOfType.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

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
    public Dog dog() {
        Dog dog = new Dog();
        return dog;
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