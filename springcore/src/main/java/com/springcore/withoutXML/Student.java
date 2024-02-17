package com.springcore.withoutXML;

import org.springframework.stereotype.Component;

@Component("firstStudent")
public class Student {
    
    public void studentStatus(){
        System.out.println("Student is active");
    }
}
