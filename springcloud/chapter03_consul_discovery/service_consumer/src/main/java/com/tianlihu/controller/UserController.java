package com.tianlihu.controller;

import com.tianlihu.api.UserApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserApi userApi;

    @RequestMapping("/user/list")
    public String list() {
        // 1. 采用HttpClient/HttpUrlConnection
        // 2. RestTemplate
        // 3. Feign
        return "消费者：" + userApi.list();
    }
}
