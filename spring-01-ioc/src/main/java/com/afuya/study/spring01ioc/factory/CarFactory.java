package com.afuya.study.spring01ioc.factory;

import com.afuya.study.spring01ioc.bean.Car;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/2 20:59
 */

/**
 * beanFactory的使用场景，制造比较复杂的对象
 */
@Component
public class CarFactory implements FactoryBean<Car> {

    /**
     * 调用此方法给容器中制造对象
     * @return
     * @throws Exception
     */
    @Override
    public Car getObject() throws Exception {
        return new Car();
    }

    /**
     * 制造的 bean 的类型，方便多态的时候使用
     * @return
     */
    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    /**
     * 是否单例
     * true：单例
     * false：非单例
     * @return
     */
    @Override
    public boolean isSingleton() {
        return true;
    }
}
