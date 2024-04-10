package com.jpa.springbootjpa.Dao;

import java.util.*;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.jpa.springbootjpa.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByCountry(String country);

    public List<User> findByNameAndCity(String name, String city);

    // Cerating custom methods with query - JPQL

    @Query("select u FROM User u")
    public List<User> getAllUsers();

    @Query("select u FROM User u WHERE u.name=:name")
    public List<User> getUsersByName(@Param("name") String userName);

    // Cerating custom methods with query - Naitive

    @Query(value = "select * FROM User WHERE id=:userId", nativeQuery = true)
    public User getUserById(@Param("userId") Long userId);
}
