package com.springcore.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Groceries {
    
    private String name;

    @Override
    public String toString() {
        return "Groceries [name=" + name + "]";
    }

    @PostConstruct
    public void start(){
        System.out.println("Init called - Groceries");
    }

    @PreDestroy
    public void end(){
        System.out.println("Destroy called - Groceries");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}