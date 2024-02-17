package com.springcore.withoutXML;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(javaConfig.class);

        Student student = context.getBean("getStudent", Student.class);
        System.out.println(student);
        student.studentStatus();
        
    }
}
