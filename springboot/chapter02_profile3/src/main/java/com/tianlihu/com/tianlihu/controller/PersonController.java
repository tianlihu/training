package com.tianlihu.com.tianlihu.controller;

import com.tianlihu.com.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @Autowired
    private Person person;

    @RequestMapping("/person/info")
    public Person info() {
        return person;
    }
}
