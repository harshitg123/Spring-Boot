package com.spring.orm;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        StudentDao stDaoObj = context.getBean("studentDaoImpl", StudentDao.class);

        Student st = new Student();

        st.setStudentId(44);
        st.setStudentName("Harshit Gupta");
        st.setStudentCity("Karera");

        stDaoObj.insert(st);
    }
}
