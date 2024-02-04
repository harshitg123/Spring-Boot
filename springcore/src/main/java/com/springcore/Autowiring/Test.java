package com.springcore.Autowiring;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        
        AbstractApplicationContext context = new ClassPathXmlApplicationContext("classpath*:autowiringConfig.xml");
        Employee emp1 = context.getBean("employee1", Employee.class);
        System.out.println(emp1);
        context.close();
    }
}
