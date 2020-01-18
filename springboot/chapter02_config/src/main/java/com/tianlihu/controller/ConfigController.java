package com.tianlihu.controller;

import com.tianlihu.config.Dog;
import com.tianlihu.config.Person;
import com.tianlihu.dao.DogDao;
import com.tianlihu.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigController {

    @Autowired
    private Person person;
    @Autowired
    private PersonDao personDao;
    @Autowired
    private DogDao dogDao;
    @Autowired
    private Dog dog;

    @RequestMapping("/config")
    public Person config() {
        System.out.println("personDao: " + personDao);
        System.out.println("dogDao: " + dogDao);
        System.out.println("dog: " + dog);
        return person;
    }
}
