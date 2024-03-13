package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

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

        ApplicationContext context = new AnnotationConfigApplicationContext(HibernateConfig.class);
        StudentDao stDaoObj = context.getBean("studentImpl", StudentDao.class);

        Student st = new Student();

        // st.setStudentId(34);
        // st.setStudentName("Ayush Joshi");
        // st.setStudentCity("Bhopal");

        // stDaoObj.insert(st);

        // stDaoObj.deleteStudentById(55);

        // ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/orm/config.xml");
        // StudentDao studentDao = context.getBean("studentDaoImpl", StudentDao.class);

        // Student st = new Student();

        // st.setStudentId(54);
        // st.setStudentName("Kuljeet Kaur");
        // st.setStudentCity("Bhopal");

        // studentDao.insert(st);

        // System.out.println(stDaoObj.getStudentById(54).toString());
        
        // get all students
        // System.out.println(stDaoObj.getStudents().toString());

        // UPDATE

        // st.setStudentId(54);
        // st.setStudentName("Mahi Meena");
        // st.setStudentCity("Bhopal");

        // System.out.println(stDaoObj.updateStudent(st));


        System.out.println("******************* Welcome to spring orm projects ********************");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean runApplication = true;

        while (runApplication) {
            System.out.println("Press 1 for new student");
            System.out.println("Press 2 for display all student");
            System.out.println("Press 3 for get details of a single student");
            System.out.println("Press 4 for delete student");
            System.out.println("Press 5 for update student");
            System.out.println("Press 6 for exit");

            try {

                int option = Integer.parseInt(br.readLine());

                switch (option) {
                    case 1:
                        
                        break;
                
                    case 2:
                        
                        break;
                
                    case 3:
                        
                        break;
                
                    case 4:
                        
                        break;
                
                    case 5:
                        
                        break;
                
                    case 6 :
                        runApplication = false;
                        System.out.println("Thank you for using HG CLI application!");
                        break;
                }
                
            } catch (Exception e) {
               System.out.println("");
               System.out.println(e.getMessage());
            }
        }

    }
}
