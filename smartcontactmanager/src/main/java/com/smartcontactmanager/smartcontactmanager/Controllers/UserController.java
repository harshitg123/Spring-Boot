package com.smartcontactmanager.smartcontactmanager.Controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.User;

import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/dashboard")
    public String userDashboard(Model model, Principal principal) {

        String username = principal.getName();
        System.out.println("Username " + username);

        User user = userRepository.findByEmail(username);
        System.out.println(user);

        model.addAttribute("user", user);

        return "normal/user-dashboard";
    }

}
