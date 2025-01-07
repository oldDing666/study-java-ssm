package com.afuya.study.spring01ioc.datasource;

import lombok.Data;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/7 23:04
 */
@Data
public class MyDataSource {
    private String driverClass;
    private String url;
    private String username;
    private String password;
}
