package com.jwtauthentican.entity;

public class User {
    private String userId;
    private String name;
    private String email;
    private String age;
    private String phone;
    private String city;

    @Override
    public String toString() {
        return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", age=" + age + ", phone=" + phone
                + ", city=" + city + "]";
    }

    public String getUserId() {
        return userId;
    }

    public User(String userId, String name, String email, String age, String phone, String city) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.age = age;
        this.phone = phone;
        this.city = city;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

}
