package com.tianlihu.controller;

import com.tianlihu.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping("/indexPage")
    public String index(Model model) {
        model.addAttribute("name", "张三");
        model.addAttribute("age", 20);

        User user = new User();
        user.setId(2);
        user.setName("李四");
        user.setAge(50);
        model.addAttribute("user", user);

        return "index";
    }
}
