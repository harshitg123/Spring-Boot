package com.spring.jdbc.Dao;

import com.spring.jdbc.Entity.Student;

public interface StudentDao {
    public int insert(Student student);
    public int modify(Student student);
    public int remove(Student student);
}
