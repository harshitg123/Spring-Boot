package com.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.mvc.dao.UserDao;
import com.spring.mvc.model.User;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;
    
    public Long createUser(User user){
        Long id = this.userDao.saveUser(user);
        System.out.println("In service");
        return id;
    }

}
