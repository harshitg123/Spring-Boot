package com.aop.Aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {
    
    // Advise
    @Before("execution(* com.aop.Dao.paymentServiceDaoImpl.PaymentServiceDaoImpl.deductMoney(..))") 
    //expression * represents all return types
    // .. represents it has arguments
    // * com.aop.Dao.paymentServiceDaoImpl.PaymentServiceDaoImpl * represents run this before all the methods
    public void paymentStarted(){
        System.out.println("AOP - Transaction started");
    }

    @After("execution(* com.aop.Dao.paymentServiceDaoImpl.PaymentServiceDaoImpl.addMoney(..))")
    public void paymentDone(){
        System.out.println("AOP - Transaction successfull");
    }
}
