package com.tianlihu.controller;

import com.tianlihu.config.MailConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {

    @Autowired
    private MailConfiguration mailConfiguration;

    @RequestMapping("/mail/config")
    public MailConfiguration config() {
        return mailConfiguration;
    }
}
