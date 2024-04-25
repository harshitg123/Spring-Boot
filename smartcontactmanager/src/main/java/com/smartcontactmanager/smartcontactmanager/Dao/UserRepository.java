package com.smartcontactmanager.smartcontactmanager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontactmanager.smartcontactmanager.Entites.User;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // @Query("select u from User u where u.email = : email")
    // public User getUserByUsername(@Param(value = "email") String email);

    public User findByEmail(String email);

}
