package com.spring.orm.Dao;

import java.util.List;

import com.spring.orm.Entity.Student;

public interface StudentDao {
    
    public void insert(Student student);
    public void deleteStudentById(int StudentId);
    public Student getStudentById(int StudentId);
    public List<Student> getStudents();
    public Student updateStudent(Student student);
}
