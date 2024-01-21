package com.springcore.collections;

import java.util.*;

public class Employe {
    private String employeeName;
    private List<String> phones;
    private Set<String> addresses;
    private Map<String, String> courses;
    private Properties props;
    
    public String getEmployeeName() {
        return employeeName;
    }
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }
    public List<String> getPhones() {
        return phones;
    }
    public void setPhones(List<String> phones) {
        this.phones = phones;
    }
    public Set<String> getAddresses() {
        return addresses;
    }
    public void setAddresses(Set<String> addresses) {
        this.addresses = addresses;
    }
    public Map<String, String> getCourses() {
        return courses;
    }
    public void setCourses(Map<String, String> courses) {
        this.courses = courses;
    }
    
    public Employe() {
    }
    public Employe(String employeeName, List<String> phones, Set<String> addresses, Map<String, String> courses) {
        this.employeeName = employeeName;
        this.phones = phones;
        this.addresses = addresses;
        this.courses = courses;
    }
    @Override
    public String toString() {
        return "Employe [employeeName=" + employeeName + ", phones=" + phones + ", addresses=" + addresses
                + ", courses=" + courses + "]";
    }
    public Properties getProps() {
        return props;
    }
    public void setProps(Properties props) {
        this.props = props;
    }


    
}
