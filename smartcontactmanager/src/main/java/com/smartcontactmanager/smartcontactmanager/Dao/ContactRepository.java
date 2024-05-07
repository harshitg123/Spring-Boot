package com.smartcontactmanager.smartcontactmanager.Dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.smartcontactmanager.smartcontactmanager.Entites.Contact;
import com.smartcontactmanager.smartcontactmanager.Entites.User;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    public Page<Contact> findByUser(User user, Pageable pageable);

    @Query("from Contact as d where d.user.id =:id")
    public Page<Contact> findContactsByUserId(@Param("id") Long id, Pageable pageable);

    public List<Contact> findByNameContainingAndUser(String name, User user);

}
