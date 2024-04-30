package com.smartcontactmanager.smartcontactmanager.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontactmanager.smartcontactmanager.Entites.Contact;
import com.smartcontactmanager.smartcontactmanager.Entites.User;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    public List<Contact> findByUser(User user);

    @Query("from Contact as d where d.user.id =:id")
    public List<Contact> findContactsByUserId(@Param("id") Long id);

}
