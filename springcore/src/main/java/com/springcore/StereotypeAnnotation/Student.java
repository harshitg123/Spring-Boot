package com.springcore.StereotypeAnnotation;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// if "bean" was not given in component it will use 
// "student" as default in camel case.

@Component("bean")
public class Student {

    @Value("Harshit Gupta")
    private String studentName;

    @Value("943590594")
    private String phoneNum;

    public String getStudentName() {
        return studentName;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public String getPhoneNum() {
        return phoneNum;
    }
    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }
    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", phoneNum=" + phoneNum + "]";
    }
}
