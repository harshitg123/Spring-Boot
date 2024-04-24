package com.smartcontactmanager.smartcontactmanager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontactmanager.smartcontactmanager.Entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = : email")
    public User getUserByUsername(@Param(value = "email") String email);

}
