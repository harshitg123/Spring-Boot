package com.spring.mvc.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.spring.mvc.model.User;

@Repository
@EnableTransactionManagement
public class UserDao {
    
    @Autowired
    private SessionFactory sessionFactory;


    @Transactional
    public Long saveUser(User user){

        sessionFactory.getCurrentSession().persist(user);

        Long id = (Long) sessionFactory.getCurrentSession().getIdentifier(user);
        System.out.println(id);

        if (id != null) {
            System.out.println("record persisted.....");
            return id;
        } else {
            return 0l;
        }
    }
}
