package com.spring.orm.Dao;

import com.spring.orm.Entity.Student;

public interface StudentDao {
    
    public void insert(Student student);
    public void deleteStudentById(int id);
}
