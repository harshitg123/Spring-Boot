package com.spring.orm.Dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entity.Student;


@Repository
@Transactional
@EnableTransactionManagement
public class StudentDaoImpl implements StudentDao{

    @Autowired
    private SessionFactory sessionFactory;


    // Insert record
    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }

    // Delete record
    @Override
    public void deleteStudentById(int StudentId) {
        Student st = new Student();
        st.setStudentId(StudentId);
        sessionFactory.getCurrentSession().remove(st);
    }

    // Get the single data
    @Override
    public Student getStudentById(int StudentId) {
        Student st = sessionFactory.getCurrentSession().get(Student.class, StudentId);
        return st;
    }
    
    // Get All the data
    @Override
    public List<Student> getStudents(){
        return sessionFactory.getCurrentSession()
                             .createQuery("from Student", Student.class)
                             .list();
    }

    // Update the given data
    @Override
    public Student updateStudent(Student student){
        return sessionFactory.getCurrentSession().merge(student);
    }


    // public void setSessionFactory(SessionFactory sessionFactory) {
    //     this.sessionFactory = sessionFactory;
    // }
    
}
