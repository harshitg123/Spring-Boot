package com.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.aop.Dao.PaymentServiceDao;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        ApplicationContext context = new ClassPathXmlApplicationContext("classpath*:config.xml");

        PaymentServiceDao paymentServiceDao = context.getBean("paymentServiceDaoImpl", PaymentServiceDao.class);
        
        // run some other bussiness logic before deductMoney() without modifing
        paymentServiceDao.deductMoney(334);

        // run some other bussiness logic after addMoney() without modifing
        paymentServiceDao.addMoney(334);
    }
}
