package com.tianlihu.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @RequestMapping("/user/list")
    public String list() {
        return "服务提供者_用户列表";
    }
}
