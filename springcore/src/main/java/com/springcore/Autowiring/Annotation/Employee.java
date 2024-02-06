package com.springcore.Autowiring.Annotation;

import org.springframework.beans.factory.annotation.Autowired;

public class Employee {

    // Property injection - Type will check
    // @Autowired
    private Address address;

    public Address getAddress() {
        return address;
    }

    // Setter injection - Type will check
    @Autowired
    public void setAddress(Address address) {
        System.out.println("Setter called");
        this.address = address;
    }

    // Constructor injection - Type will check
    // @Autowired
    public Employee(Address address) {
        System.out.println("Constructor called");
        this.address = address;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee [address=" + address + "]";
    }
}
