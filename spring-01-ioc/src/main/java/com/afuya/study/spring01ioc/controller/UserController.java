package com.afuya.study.spring01ioc.controller;

import com.afuya.study.spring01ioc.bean.Dog;
import com.afuya.study.spring01ioc.bean.Person;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.Map;

/**
 * @author: afuya
 * @program: study-java-ssm
 * @date: 2024/12/30 21:49
 */
@Data
@Controller
public class UserController {

    @Autowired
    Dog dog;

    @Autowired
    List<Person> persons;

    @Autowired
    Map<String, Person> personMap;

    @Autowired
    ApplicationContext context;
}
