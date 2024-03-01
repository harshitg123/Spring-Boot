package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.Dao.StudentDao;
import com.spring.jdbc.Dao.StudentDaoImpl;
import com.spring.jdbc.Entity.Student;
import com.spring.jdbc.JdbcConfiguration.JdbcConfiguration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started" );


        // ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config.xml");

        ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfiguration.class);

        // This will have all the fun to be performed for e.g. insert, delete....
        StudentDao studentDao = context.getBean("studentImpl", StudentDao.class);

        // INSERT

        // Student studentObj = new Student();
        
        // studentObj.setId(55);
        // studentObj.setName("Mahi meena");
        // studentObj.setCity("Bhopal");

        // int result = studentDao.insert(studentObj);

        // System.out.println("Number of record inserted: "+ result);


        // UPDATE

        // Student studentObj = new Student();
        // studentObj.setId(55);
        // studentObj.setName("Kuljeet");
        // studentObj.setCity("Bhopal");

        // int result = studentDao.modify(studentObj);

        // System.out.println("Total modified data: " + result);


        // DELETE

        // Student studentObj = new Student();
        // studentObj.setId(55);

        // int result = studentDao.remove(studentObj);

        // System.out.println("Total modified data: " + result);


        // GET STUDENT DATA SELECT 

        // Student student = studentDao.getStudent(34);
        // System.out.println(student);


        // GET ALL STUDENT DATA'
        List<Student> student = studentDao.getAllStudents();

        for (Student student2 : student) {
            System.out.println(student2);
        }
        

    }
}
