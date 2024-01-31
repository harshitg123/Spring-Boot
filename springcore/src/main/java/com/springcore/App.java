package com.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.springcore.collections.Employe;
import com.springcore.constructor.Person;
import com.springcore.constructor.AmbigutyProblem.Addition;
import com.springcore.lifecycle.Fruit;
import com.springcore.reference.A;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        // System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");
        Student student1 =(Student)context.getBean("student1");
        Student student2 =(Student) context.getBean("student2");
        Student student3 =(Student) context.getBean("student3");
        
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student3);

        ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath*:collectionConfig.xml");
        Employe employe1 =(Employe) context2.getBean("employe1");

        System.out.println(employe1.getEmployeeName());
        System.out.println(employe1.getAddresses());
        System.out.println(employe1.getCourses());
        System.out.println(employe1.getPhones());
        System.out.println(employe1.getProps());

        ApplicationContext context3 = new ClassPathXmlApplicationContext("classpath*:referenceConfig.xml");
        A aObj = (A) context3.getBean("Aref");

        System.out.println(aObj.getX());
        System.out.println(aObj.getObj().getY());


        ApplicationContext context4 = new ClassPathXmlApplicationContext("classpath*:constructorConfig.xml");
        Person person = (Person) context4.getBean("person");
        System.out.println(person);

        Addition add = (Addition) context4.getBean("addition");
        System.out.println(add.doSum());


        // Implementation of bean lifecycle methods

        // 1. Using XML configurations

        AbstractApplicationContext context5 = new ClassPathXmlApplicationContext("classpath*:lifecycle.xml");
        Fruit fruit = (Fruit) context5.getBean("fruit");
        System.out.println(fruit);

        //Will close the context just before the JVM is shutting down for whatever reason.
        context5.registerShutdownHook();

        // will close the context at the time it is invoked.
        // context5.close();


        // 2. Using Spring Interfaces

        

    }
}
