package com.aop.Dao;

public interface PaymentServiceDao {
    public void deductMoney(int amount);
    public void addMoney(int amount);
}
