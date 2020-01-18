package com.tianlihu.controller;

import com.tianlihu.entity.User;
import com.tianlihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public List<User> list() {
        return userService.selectAll();
    }
}
