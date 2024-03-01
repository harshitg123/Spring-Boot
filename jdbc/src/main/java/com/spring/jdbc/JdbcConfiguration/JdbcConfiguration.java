package com.spring.jdbc.JdbcConfiguration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.Dao.StudentDaoImpl;

@Configuration
public class JdbcConfiguration {
    

    @Bean("dbprops")
    public DriverManagerDataSource getDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/springjdbc");
        dataSource.setUsername("root");
        dataSource.setPassword("qwsx##HG##123");
        return dataSource;
    }

    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate(){
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(getDataSource());
        return jdbcTemplate;
    }

    @Bean("studentImpl")
    public StudentDaoImpl getStudentDao(){
        StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
        studentDaoImpl.setJdbcTemplate(getJdbcTemplate());
        return studentDaoImpl;
    }

}
