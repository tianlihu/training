package com.tianlihu.controller;

import com.tianlihu.User;
import com.tianlihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public String list(Integer pageNum, Integer pageSize) {
        return userService.list(pageNum, pageSize);
    }

    @RequestMapping("/user/save")
    public String save(User user) {
        return userService.save(user);
    }

    @RequestMapping("/user/update")
    public String update(@RequestBody User user) {
        return "修改用户成功: " + user.getId();
    }
}
