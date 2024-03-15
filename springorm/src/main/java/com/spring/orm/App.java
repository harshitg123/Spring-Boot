package com.spring.orm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.spring.orm.Config.HibernateConfig;
import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entity.Student;

import jakarta.persistence.criteria.CriteriaBuilder.In;

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

                        System.out.println("Enter student Id: ");
                        int uId = Integer.parseInt(br.readLine());

                        System.out.println("Enter student name: ");
                        String uName = br.readLine();

                        System.out.println("Enter student city: ");
                        String uCity = br.readLine();

                        Student student = new Student();
                        student.setStudentId(uId);
                        student.setStudentName(uName);
                        student.setStudentCity(uCity);

                        stDaoObj.insert(student);

                        System.out.println(uName + " has been added!");

                        break;
                
                    case 2:

                        System.out.println("All students: ");
                        System.out.println(stDaoObj.getStudents());
                        break;
                
                    case 3:

                        System.out.println("Enter student id: ");
                        int sid = Integer.parseInt(br.readLine());
                        System.out.println(stDaoObj.getStudentById(sid));
                        break;
                
                    case 4:

                        System.out.println("Enter student id to delete: ");
                        int sidtoDelete = Integer.parseInt(br.readLine());
                        String sName = stDaoObj.getStudentById(sidtoDelete).getStudentName();
                        stDaoObj.deleteStudentById(sidtoDelete);
                        System.out.println(sName + " has been deleted!");
                        break;
                
                    case 5:

                        System.out.println("To edit all the properties enter 'Yes' else 'No'");
                        String check = br.readLine();

                        if(check.toLowerCase().equals("yes")){
                            System.out.println("Enter student id: ");
                            int stIdToUpdate = Integer.parseInt(br.readLine());

                            if(stDaoObj.getStudentById(stIdToUpdate).getStudentName() != null) {
                                
                                System.out.println("Enter student name: ");
                                String studentNameToUpdate = br.readLine();

                                System.out.println("Enter city to update: ");
                                String studentCityUpdate = br.readLine();
                                
                                Student stToUpdate = new Student();

                                stToUpdate.setStudentId(stIdToUpdate);
                                st.setStudentName(studentNameToUpdate);
                                st.setStudentCity(studentCityUpdate);   

                                System.out.println(stDaoObj.updateStudent(stToUpdate));

                            }else{
                                System.out.println("Please enter valid user id!");
                            }
                        }else{
                            System.out.println("Enter 1 to update name and 2 for city: ");
                            int choice = Integer.parseInt(br.readLine());

                            if (choice == 1) {

                                System.out.println("Enter student id: ");
                                int stIdToUpdate = Integer.parseInt(br.readLine());

                                if (stDaoObj.getStudentById(stIdToUpdate).getStudentName() != null) {
                                    System.out.println("Enter student name: ");
                                    String studentNameToUpdate = br.readLine();
    
                                    Student stToUpdate = new Student();
    
                                    stToUpdate.setStudentId(stIdToUpdate);
                                    stToUpdate.setStudentName(studentNameToUpdate);
                                    stToUpdate.setStudentCity(stDaoObj.getStudentById(stIdToUpdate).getStudentCity());
    
                                    System.out.println(stDaoObj.updateStudent(stToUpdate));
    
                                } else {
                                    System.out.println("Please enter valid user id!");
                                }
                            } else {
                                System.out.println("Enter student id: ");
                                int stIdToUpdate = Integer.parseInt(br.readLine());

                                if (stDaoObj.getStudentById(stIdToUpdate).getStudentName() != null) {
                                    System.out.println("Enter student city: ");
                                    String studentCityToUpdate = br.readLine();
    
                                    Student stToUpdate = new Student();
    
                                    stToUpdate.setStudentId(stIdToUpdate);
                                    st.setStudentCity(studentCityToUpdate);
    
                                    System.out.println(stDaoObj.updateStudent(stToUpdate));
                                }else{
                                    System.out.println("Please enter valid user id!");
                                }
                            }
                        }
                        
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
