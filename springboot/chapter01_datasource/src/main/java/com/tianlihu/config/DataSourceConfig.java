package com.tianlihu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.jolbox.bonecp.BoneCPDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.zaxxer.hikari.HikariDataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean("hikariDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.hikari")
    public DataSource hikariDataSource(){
        return DataSourceBuilder.create().type(HikariDataSource.class).build();
    }

    @Bean("druidDataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Bean("boneCpDataSource")
    @ConfigurationProperties(prefix = "bonecp")
    public DataSource boneCpDataSource() {
        return DataSourceBuilder.create().type(BoneCPDataSource.class).build();
    }

    @Bean("c3p0DataSource")
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource c3p0DataSource() {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }

    @Primary
    @Bean("dhcp2DataSource")
    @ConfigurationProperties(prefix = "dhcp2")
    public DataSource c3poDataSource() {
        return DataSourceBuilder.create().type(BasicDataSource.class).build();
    }
}
