package com.springcore.StereotypeAnnotation;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// if "bean" was not given in component it will use 
// "student" as default in camel case.

@Component("bean")
@Scope("prototype")
public class Student {

    @Value("Harshit Gupta")
    private String studentName;

    @Value("943590594")
    private String phoneNum;

    @Value("#{address}")
    private List<String> addresses;

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
    public List<String> getAddresses() {
        return addresses;
    }
    public void setAddresses(List<String> addresses) {
        this.addresses = addresses;
    }
    @Override
    public String toString() {
        return "Student [studentName=" + studentName + ", phoneNum=" + phoneNum + "]";
    }
    
}
