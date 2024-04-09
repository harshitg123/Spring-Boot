package com.jpa.springbootjpa.Dao;

import java.util.*;
import org.springframework.data.repository.CrudRepository;

import com.jpa.springbootjpa.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    public List<User> findByCountry(String country);

    public List<User> findByNameAndCity(String name, String city);

}
