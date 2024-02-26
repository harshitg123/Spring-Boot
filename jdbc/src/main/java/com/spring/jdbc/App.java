package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;
import com.spring.jdbc.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started" );


        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

        // This will have all the fun to be performed for e.g. insert, delete....
        StudentDao studentDao = context.getBean("studentImpl", StudentDao.class);

        Student studentObj = new Student();
        
        studentObj.setId(55);
        studentObj.setName("Mahi meena");
        studentObj.setCity("Bhopal");

        int result = studentDao.insert(studentObj);

        System.out.println("Number of record inserted: "+ result);

    }
}
