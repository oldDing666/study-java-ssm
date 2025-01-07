package com.afuya.study.spring01ioc.repository;

import com.afuya.study.spring01ioc.datasource.MyDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2025/1/7 23:08
 */
@Repository
@Data
public class DataSourceDao {

    @Autowired
    MyDataSource dataSource;

}
