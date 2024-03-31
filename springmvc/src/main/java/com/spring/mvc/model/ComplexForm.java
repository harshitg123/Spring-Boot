package com.spring.mvc.model;

import java.util.*;

public class ComplexForm {
    
    private Long id;
    private String email;
    private String date;
    private List<String> courses;
    private String platform;
    private String gender;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public List<String> getCourses() {
        return courses;
    }
    public void setCourses(List<String> courses) {
        this.courses = courses;
    }
    public String getPlatform() {
        return platform;
    }
    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return "ComplexForm [id=" + id + ", email=" + email + ", date=" + date + ", courses=" + courses + ", platform="
                + platform + ", gender=" + gender + "]";
    }

    
}
