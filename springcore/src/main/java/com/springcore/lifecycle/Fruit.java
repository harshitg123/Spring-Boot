package com.springcore.lifecycle;

public class Fruit {
    
    private String name;
    private double price;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        System.out.println("Setting name.");
        this.name = name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        System.out.println("Setting price.");
        this.price = price;
    }
    
    @Override
    public String toString() {
        return "Fruit [name=" + name + ", price=" + price + "]";
    }

    public void init(){
        System.out.println("Init method called!");
    }

    public void destroy(){
        System.out.println("Destroy method called!");
    }

}
