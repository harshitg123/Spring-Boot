package com.springcore.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Expression {
    
    @Value("#{12+8}")
    private int add;

    @Value("#{110-9}")
    private int subtract;

    @Value("#{ T(java.lang.Math).sqrt(144) }")
    private double squareRoot;

    @Value("#{ T(java.lang.Math).PI }")
    private double piValue;

    @Value("#{ new java.lang.String('Harshit Gupta') }")
    private String name;

    @Value("#{ new java.lang.Integer(44) }")
    private int rollNum;
    
    public int getAdd() {
        return add;
    }
    public void setAdd(int add) {
        this.add = add;
    }
    public int getSubtract() {
        return subtract;
    }
    public void setSubtract(int subtract) {
        this.subtract = subtract;
    }
    public double getSquareRoot() {
        return squareRoot;
    }
    public void setSquareRoot(double squareRoot) {
        this.squareRoot = squareRoot;
    }
    public double getPiValue() {
        return piValue;
    }
    public void setPiValue(double piValue) {
        this.piValue = piValue;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getRollNum() {
        return rollNum;
    }
    public void setRollNum(int rollNum) {
        this.rollNum = rollNum;
    }
    @Override
    public String toString() {
        return "Expression [add=" + add + ", subtract=" + subtract + ", squareRoot=" + squareRoot + ", piValue="
                + piValue + ", name=" + name + ", rollNum=" + rollNum + "]";
    }
    
    
}
