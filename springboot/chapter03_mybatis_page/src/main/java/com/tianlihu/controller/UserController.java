package com.tianlihu.controller;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.tianlihu.entity.User;
import com.tianlihu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user/list")
    public String list(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "5") Integer pageSize,
            Model model) {
        PageHelper.startPage(pageNum, pageSize);
        Page<User> page = userService.selectAll();
        model.addAttribute("pageInfo", page);
        return "/user/list";
    }
}
