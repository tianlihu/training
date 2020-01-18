package com.tianlihu.controller;

import com.tianlihu.entity.User;
import com.tianlihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list(String name) {
        return userService.list(name);
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public User save(User user) {
        userService.save(user);
        return user;
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    public User update(User user) {
        userService.update(user);
        return user;
    }

    @RequestMapping(value = "/user/delete", method = {RequestMethod.GET, RequestMethod.POST})
    public String delete(Integer id) {
        userService.delete(id);
        return "success";
    }
}
