package com.tianlihu.controller;

import com.tianlihu.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@Controller
public class IndexController {

    @RequestMapping("/index")
    public String index(Model model) {
        Student student = new Student();
        student.setId(1);
        student.setName("张三");
        student.setAge(20);
        student.setBirthday(new Date());
        model.addAttribute("student", student);
        return "index";
    }
}
