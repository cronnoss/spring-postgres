package com.cronnoss.springpostgres.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:postgresql://localhost:5432/users");
        config.setUsername("root");
        config.setPassword("secretkey");
        config.setMaximumPoolSize(10);
        return new HikariDataSource(config);
    }
}
