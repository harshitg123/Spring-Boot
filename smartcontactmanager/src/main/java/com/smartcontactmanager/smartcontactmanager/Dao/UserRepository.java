package com.smartcontactmanager.smartcontactmanager.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smartcontactmanager.smartcontactmanager.Entites.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
