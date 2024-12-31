package com.afuya.study.spring01ioc.config;

import ch.qos.logback.core.CoreConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/31 21:52
 */

/**
 * 导入第三方的组件的方式
 * （1）使用@bean，自己通过new的方式放入容器中
 * （2）@Import直接放入容器中
 *
 * 推荐将@ComponentScan，@Import放到配置类中，使得主类更加简洁
 */
@Configuration
@Import(CoreConstants.class)
@ComponentScan(basePackages = "com.afuya.study")
public class AppConfig {

    @Bean
    public CoreConstants coreConstant001() {
        return new CoreConstants();
    }
}
