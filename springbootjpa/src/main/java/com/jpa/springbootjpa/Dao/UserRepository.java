package com.jpa.springbootjpa.Dao;

import org.springframework.data.repository.CrudRepository;

import com.jpa.springbootjpa.Model.User;

public interface UserRepository extends CrudRepository<User, Long> {

}
