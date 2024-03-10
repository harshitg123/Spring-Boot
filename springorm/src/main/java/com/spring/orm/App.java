package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Config.HibernateConfig;
import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entity.Student;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application started!" );

        // ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        // StudentDao stDaoObj = context.getBean("studentImpl", StudentDao.class);

        // Student st = new Student();

        // st.setStudentId(34);
        // st.setStudentName("Ayush Joshi");
        // st.setStudentCity("Bhopal");

        // stDaoObj.insert(st);

        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

        Student st = new Student();

        st.setStudentId(54);
        st.setStudentName("Kuljeet Kaur");
        st.setStudentCity("Bhopal");

        studentDao.insert(st);
    }
}
