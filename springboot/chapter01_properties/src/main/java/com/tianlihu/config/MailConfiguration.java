package com.tianlihu.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Data
@Component
@PropertySource("classpath:mail.properties")
@ConfigurationProperties(prefix = "mail")
public class MailConfiguration {

    private String host;
    private Integer port;
    private String username;
    private String password;
    private String title;
    private String replay;

    private ReceiveUser receiveUser;
}
