package com.tianlihu.config;

import com.tianlihu.dao.DogDao;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:spring-config.xml")
public class SpringConfig {

    @Bean("daoDao")
    public DogDao dogDao() {
        return new DogDao();
    }

    @Bean
    @ConfigurationProperties(prefix = "person.dog")
    public Dog dog() {
        return new Dog();
    }
}
