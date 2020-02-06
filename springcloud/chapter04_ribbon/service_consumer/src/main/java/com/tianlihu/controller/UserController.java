package com.tianlihu.controller;

import com.tianlihu.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UserController {

    @Autowired
    private UserApi userApi;

    @RequestMapping("/user/list")
    public String list() {
        String result = "消费者：" + userApi.list();
        System.out.println(result);
        return result;
    }
}
