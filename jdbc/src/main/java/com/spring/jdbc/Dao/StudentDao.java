package com.spring.jdbc.Dao;

import java.util.List;

import com.spring.jdbc.Entity.Student;

public interface StudentDao {
    public int insert(Student student);
    public int modify(Student student);
    public int remove(Student student);
    public Student getStudent(int studentId);
    public List<Student> getAllStudents();
}
