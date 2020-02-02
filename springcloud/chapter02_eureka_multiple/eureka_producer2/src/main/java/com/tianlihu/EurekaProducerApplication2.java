package com.tianlihu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EurekaProducerApplication2 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProducerApplication2.class, args);
    }
}
