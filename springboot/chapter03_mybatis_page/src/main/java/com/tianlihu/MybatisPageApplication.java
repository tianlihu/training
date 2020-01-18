package com.tianlihu;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.tianlihu.mapper")
@SpringBootApplication
public class MybatisPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPageApplication.class, args);
    }

}
