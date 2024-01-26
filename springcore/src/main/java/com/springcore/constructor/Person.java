package com.springcore.constructor;

import java.util.ArrayList;

/**
 * Person
 */
public class Person {

    private String name;
    private int personId;
    private Certificate certificate;
    private ArrayList<String> phoneNum;

    public Person (String name, int personId, Certificate certificate, ArrayList<String> phoneNum){
        this.name = name;
        this.personId = personId;
        this.certificate = certificate;
        this.phoneNum = phoneNum;
    }

    @Override
    public String toString() {
        return name + ":" + personId + "has" + certificate.certiName + "Certificate." + "Phones: " + phoneNum;
    }
}