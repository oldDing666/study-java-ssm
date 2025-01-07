package com.afuya.study.spring01ioc;

import ch.qos.logback.core.CoreConstants;
import com.afuya.study.outside.TestService;
import com.afuya.study.spring01ioc.bean.Car;
import com.afuya.study.spring01ioc.bean.Cat;
import com.afuya.study.spring01ioc.bean.Dog;
import com.afuya.study.spring01ioc.bean.Person;
import com.afuya.study.spring01ioc.controller.UserController;
import com.afuya.study.spring01ioc.repository.UserDao;
import com.afuya.study.spring01ioc.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Map;

@SpringBootApplication
public class Spring01IocApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        Cat cat = ioc.getBean(Cat.class);
        System.out.println(cat);
    }

    public static void func10(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        UserDao userDao = ioc.getBean(UserDao.class);
        System.out.println(userDao);
    }

    public static void func9(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        UserService userService = ioc.getBean(UserService.class);
        System.out.println(userService);
    }

    public static void func8(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        UserController userController = ioc.getBean(UserController.class);
        System.out.println(userController);
    }

    public static void fun7(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        Map<String, Person> beansOfType = ioc.getBeansOfType(Person.class);
        System.out.println(beansOfType);
        String os = ioc.getEnvironment().getProperty("OS");
        System.out.println(os);
    }

    public static void fun6(String[] args) throws Exception {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);

        /**
         * 不需要先获取工厂对象，而是直接从容器中获取 bean
         */
        Car bean1 = ioc.getBean(Car.class);
        Car bean2 = ioc.getBean(Car.class);
        System.out.println(bean1 == bean2);

        /**
         * beanFactory制造的 bean，name是 beanFactory的类名，类型是泛型中指定的类型
         */
        Map<String, Car> beansOfType = ioc.getBeansOfType(Car.class);
        beansOfType.forEach((k, v) -> System.out.println(k + " : " + v));
    }

    public static void func5(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        System.out.println("==========ioc容器启动完成==========");
        Dog dog1 = ioc.getBean(Dog.class);
        System.out.println(dog1);
        Dog dog2 = ioc.getBean(Dog.class);
        System.out.println(dog2);
    }

    /**
     * （1）ioc默认只扫描主程序所在的包及其子包
     * （2）类必须有 spring相关的注解才会被扫描到
     *
     * @param args
     */
    public static void func4(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        TestService bean = ioc.getBean(TestService.class);
        System.out.println(bean);
//        CoreConstants bean2 = ioc.getBean(CoreConstants.class);
//        System.out.println(bean2);
//        Object coreConstant001 = ioc.getBean("coreConstant001");
//        System.out.println(coreConstant001);
        Map<String, CoreConstants> beans = ioc.getBeansOfType(CoreConstants.class);
        beans.forEach((k, v) -> {
            System.out.println(k + ":" + v);
        });
    }

    /**
     * (1) 配置类也是容器中的组件
     * (2) MVC 分层注解，@Controller、@Service、@Repository底层都是@Component,可以相互替换
     * 此外@configuration底层也是@Component
     *
     * @param args
     */
    public static void fun3(String[] args) {
        ConfigurableApplicationContext ioc = SpringApplication.run(Spring01IocApplication.class, args);
        for (String beanDefinitionName : ioc.getBeanDefinitionNames()) {
            System.out.println("beanName = " + beanDefinitionName);
        }
    }

    /**
     * （1）ioc容器创建过程中，就会创建组件
     * （2）创建的组件默认是单实例的，每次获取组件都是从容器中获取
     *
     * @param args
     */
    public static void fun2(String[] args) {
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

}
