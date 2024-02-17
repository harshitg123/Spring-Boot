package com.springcore.withoutXML;

import org.springframework.stereotype.Component;

public class Student {

    private Samosa samosa;

    public void studentStatus(){
        samosa.getPrice();
        System.out.println("Student is active");
    }

    public Student(Samosa samosa) {
        this.samosa = samosa;
    }
    public Samosa getSamosa() {
        return samosa;
    }
    public void setSamosa(Samosa samosa) {
        this.samosa = samosa;
    }
}
