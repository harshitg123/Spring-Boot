package com.springcore.withoutXML;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.springcore.withoutXML")
public class javaConfig {
    
    @Bean
    public Student getStudent(){
        Student student = new Student();
        return student;
    }
}
