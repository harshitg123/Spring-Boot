package com.springcore;

public class Student {
    
    private String studentName;
    private int studentId;
    private String studentAddress;

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public int getstudentId() {
        return studentId;
    }
    public void setstudentId(int studentId) {
        this.studentId = studentId;
    }
    public String getStudentAddress() {
        return studentAddress;
    }
    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }
    public Student(String studentName, int studentId, String studentAddress) {
        this.studentName = studentName;
        this.studentId = studentId;
        this.studentAddress = studentAddress;
    }
    public Student() {
    }
    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", studentId=" + studentId + ", studentAddress=" + studentAddress + "]";
    }
}
