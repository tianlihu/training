package com.tianlihu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Value("${server.port}")
    private Integer serverPort;

    @RequestMapping("/user/list")
    public String list() {
        return "服务提供者_用户列表: " + serverPort;
    }
}
