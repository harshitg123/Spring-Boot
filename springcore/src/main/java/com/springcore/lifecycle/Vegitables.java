package com.springcore.lifecycle;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Vegitables implements InitializingBean, DisposableBean{
    
    private String name;
    private double price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return "Vegitables [name=" + name + ", price=" + price + "]";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroyed - vegitables");
    }
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Bean initilize - vegitables");
    }

    
}
