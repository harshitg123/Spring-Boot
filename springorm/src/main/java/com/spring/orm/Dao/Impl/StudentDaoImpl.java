package com.spring.orm.Dao.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;

import com.spring.orm.Dao.StudentDao;
import com.spring.orm.Entity.Student;

public class StudentDaoImpl implements StudentDao{

    @Autowired
    HibernateTemplate hibernateTemplate;

    @Override
    public Student insert(Student student) {
        Student st = (Student) hibernateTemplate.save(student);
        return st;
    }
    
}
