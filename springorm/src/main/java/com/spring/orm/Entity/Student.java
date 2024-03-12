package com.spring.orm.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
    
    @Id
    @Column(name = "student_id")
    private long studentId;
    @Column(name = "student_name")
    private String studentName;
    @Column(name = "student_city")
    private String studentCity;

    public long getStudentId() {
        return studentId;
    }
    public void setStudentId(long studentId) {
        this.studentId = studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getStudentCity() {
        return studentCity;
    }
    public void setStudentCity(String studentCity) {
        this.studentCity = studentCity;
    }
    public Student() {
    }
    public Student(long studentId, String studentName, String studentCity) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCity = studentCity;
    }
    @Override
    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", studentCity=" + studentCity
                + "]";
    }
}
