package com.smartcontactmanager.smartcontactmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.User;
import com.smartcontactmanager.smartcontactmanager.Helper.Message;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getHomePage(Model model) {
        model.addAttribute("title", "Home - Smart contact manager");
        return "home";
    }

    @GetMapping("/about")
    public String getAboutPage(Model model) {
        model.addAttribute("title", "About - Smart contact manager");
        return "about";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("title", "Register - Smart contact manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/registerUser")
    public String registerUser(
            @Valid @ModelAttribute("user") User user,
            @RequestParam(value = "tnc", defaultValue = "false") Boolean tnc,
            Model model,
            BindingResult bindingResult,
            HttpSession session) {

        try {
            // System.out.println(bindingResult);
            System.out.println(user);

            if (!tnc) {
                System.out.println("You are not aggred to terms and conditions.");
                throw new Exception("You are not aggred to terms and conditions.");
            }

            user.setRole("ROLE_USER");
            user.setActive(true);

            User result = userRepository.save(user);

            model.addAttribute("user", new User());

            session.setAttribute("message", new Message("Successfully registered", "alert-success"));

            return "signup";

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("user", user);
            session.setAttribute("message", new Message("Something went wrong!!", "alert-error"));
            return "signup";
        }

    }

}
