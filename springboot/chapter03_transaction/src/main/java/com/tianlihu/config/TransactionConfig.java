package com.tianlihu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
public class TransactionConfig {

    @Bean
    public Object testBean(PlatformTransactionManager transactionManager){
        System.out.println(transactionManager.getClass().getName());
        return new Object();
    }
}
