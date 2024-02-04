package com.springcore.Autowiring;

public class Employee {
    
    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Employee(Address address) {
        this.address = address;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee [address=" + address + "]";
    }
}
