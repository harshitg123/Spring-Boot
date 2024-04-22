package com.smartcontactmanager.smartcontactmanager.Entites;

import java.util.*;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "USER")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private Long id;
    @Column(unique = true)
    @NotEmpty(message = "Email can not be null")
    private String email;
    @NotEmpty(message = "Name can not be null")
    private String name;
    @NotEmpty(message = "Password can not be null")
    private String password;
    @Column(length = 500)
    @NotEmpty(message = "Please write about yourself")
    private String about;
    private String role;
    private boolean isActive;
    private String imageUrl;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Contact> contacts = new ArrayList<>();

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", email=" + email + ", name=" + name + ", password=" + password + ", about=" + about
                + ", role=" + role + ", isActive=" + isActive + ", imageUrl=" + imageUrl + "]";
    }

    public List<Contact> getContacts() {
        return contacts;
    }

    public void setContacts(List<Contact> contacts) {
        this.contacts = contacts;
    }

}
