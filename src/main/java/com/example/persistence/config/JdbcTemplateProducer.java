package com.example.persistence.config;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.sql.DataSource;

@ApplicationScoped
public class JdbcTemplateProducer {

    @Resource
    private DataSource dataSource;

    @Produces
    @ApplicationScoped
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource);
    }

}
