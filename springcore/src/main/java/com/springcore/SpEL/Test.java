package com.springcore.SpEL;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("com/springcore/SpEL/expressionLangConfig.xml");
        Expression exp = context.getBean("expression", Expression.class);
        System.out.println(exp);
    }
}
