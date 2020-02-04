package com.tianlihu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class ConfigController {

    @Value("${spring.datasource.url}")
    private String url;
    @Value("${spring.datasource.username}")
    private String username;
    @Value("${spring.datasource.password}")
    private String password;

    @RequestMapping("/config")
    public String config() {
        StringBuilder configs = new StringBuilder();
        configs.append("Consul配置：spring.datasource.url=" + url).append("<br>");
        configs.append("Consul配置：spring.datasource.username=" + username).append("<br>");
        configs.append("Consul配置：spring.datasource.password=" + password).append("<br>");
        return configs.toString();
    }
}
