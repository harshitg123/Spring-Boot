package com.spring.orm.Dao.Impl;

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


    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().persist(student);
    }


    // public void setSessionFactory(SessionFactory sessionFactory) {
    //     this.sessionFactory = sessionFactory;
    // }
    
}
