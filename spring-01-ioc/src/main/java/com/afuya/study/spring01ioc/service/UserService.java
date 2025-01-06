package com.afuya.study.spring01ioc.service;

import com.afuya.study.spring01ioc.bean.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:49
 */
@Service
@Data
public class UserService {

//    @Qualifier("person001")
    @Autowired
//    Person person001;
    Person person;
}
