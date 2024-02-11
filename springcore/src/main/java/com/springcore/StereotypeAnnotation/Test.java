package com.springcore.StereotypeAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    
    public static void main(String[] args) {
        
        ApplicationContext context = 
            new ClassPathXmlApplicationContext("com/springcore/StereotypeAnnotation/stereotypeAnnotationConfig.xml");
        Student student = context.getBean("bean", Student.class);
        System.out.println(student);
        System.out.println(student.getAddresses());
        System.out.println(student.hashCode());

        Student student2 = context.getBean("bean", Student.class);
        System.out.println(student2.hashCode());

        //Both the hashcode are same so this is singleton scope.
    }
}
