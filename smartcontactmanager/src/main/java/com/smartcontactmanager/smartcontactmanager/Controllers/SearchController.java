package com.smartcontactmanager.smartcontactmanager.Controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.smartcontactmanager.smartcontactmanager.Dao.ContactRepository;
import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.Contact;
import com.smartcontactmanager.smartcontactmanager.Entites.User;

@RestController
public class SearchController {

    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/search/{query}")
    public ResponseEntity<List<Contact>> getSearchResulEntity(@PathVariable("query") String query,
            Principal principal) {

        User user = userRepository.findByEmail(principal.getName());

        List<Contact> contacts = contactRepository.findByNameContainingAndUser(query, user);
        return ResponseEntity.ok(contacts);
    }

}
