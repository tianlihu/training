package com.tianlihu;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class BannerApplication {

    public static void main(String[] args) {
// 方式一：
//        // 创建SpringBoot应用
//        SpringApplication springApplication = new SpringApplication(BannerApplication.class);
//        // 设置Banner不显示
//        springApplication.setBannerMode(Banner.Mode.OFF);
//        // 启动SpringBoot应用
//        springApplication.run(args);

// 方式二：
//        new SpringApplicationBuilder().sources(BannerApplication.class).bannerMode(Banner.Mode.OFF).run(args);
//        // 原始的启动方式
         SpringApplication.run(BannerApplication.class, args);
    }
}
