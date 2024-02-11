package com.springcore.SpEL;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Expression {
    
    @Value("#{12+8}")
    private int add;

    @Value("#{110-9}")
    private int subtract;
    
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
    @Override
    public String toString() {
        return "Expression [add=" + add + ", subtract=" + subtract + "]";
    }
}
