package com.aop.Dao.paymentServiceDaoImpl;

import com.aop.Dao.PaymentServiceDao;

public class PaymentServiceDaoImpl implements PaymentServiceDao{

    @Override
    public void deductMoney(int amount) {
        System.out.println(amount + " Money debited.....");
    }

    @Override
    public void addMoney(int amount) {
        System.out.println(amount + " Money credited.....");
    }
    
}
