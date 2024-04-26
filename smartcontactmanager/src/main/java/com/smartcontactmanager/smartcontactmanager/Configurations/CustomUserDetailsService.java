package com.smartcontactmanager.smartcontactmanager.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.User;

public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("Could not found username or user");
        }

        CustomUserDetails userDetails = new CustomUserDetails(user);
        return userDetails;

    }

}
