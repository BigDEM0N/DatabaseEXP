package com.example.databaseexp3backend.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration

public class JdbcConfig {
    @Bean
    public JdbcTemplate jdbcTemplate(){
        DruidDataSource druidDataSource = new DruidDataSource();
        druidDataSource.setUrl("jdbc:mysql://127.0.0.1:3306/exp3");
        druidDataSource.setUsername("root");
        druidDataSource.setPassword("123456");
        druidDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        JdbcTemplate jdbcTemplate = new JdbcTemplate(druidDataSource);
        return jdbcTemplate;
    }
}
