package com.jwtauthentican.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.jwtauthentican.entity.User;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService() {
        users.add(new User(UUID.randomUUID().toString(), "Harshit Gupta", "harshit.28.sps@gmail.com",
                "23", "6266478162", "Pune"));
        users.add(new User(UUID.randomUUID().toString(), "Ayush Joshi", "kuljeet@gmail.com", "24",
                "48754825235", "Pune"));
        users.add(new User(UUID.randomUUID().toString(), "Kuljeet kaur", "ayush@gmail.com", "23",
                "36668545773", "Bhopal"));
    }

    public List<User> getUsers() {
        return this.users;
    }
}
