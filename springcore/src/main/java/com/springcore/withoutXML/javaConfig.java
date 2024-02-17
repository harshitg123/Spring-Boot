package com.springcore.withoutXML;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class javaConfig {
    
    @Bean // This will let IOC container know to handle the object of the bean
    public Student getStudent(){
        Student student = new Student(getSamosa());
        return student;
    }

    @Bean
    public Samosa getSamosa(){
        Samosa samosa = new Samosa();
        return samosa;
    }
}
