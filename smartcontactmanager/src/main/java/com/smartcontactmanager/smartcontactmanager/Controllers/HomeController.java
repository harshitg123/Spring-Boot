package com.smartcontactmanager.smartcontactmanager.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.smartcontactmanager.smartcontactmanager.Dao.UserRepository;
import com.smartcontactmanager.smartcontactmanager.Entites.User;
import com.smartcontactmanager.smartcontactmanager.Helper.Message;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

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

    @GetMapping("/signin")
    public String getloginPage(Model model) {
        model.addAttribute("title", "Login - Smart contact manager");
        model.addAttribute("user", new User());
        return "login";
    }

    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        model.addAttribute("title", "Register - Smart contact manager");
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/registerUser")
    public String registerUser(
            @Valid @ModelAttribute("user") User user, BindingResult result,
            @RequestParam(value = "tnc", defaultValue = "false") boolean tnc,
            Model model) {

        try {

            System.out.println(user);
            System.out.println(tnc);

            if (!tnc) {
                System.out.println("You are not aggred to terms and conditions.");
                throw new Exception("You are not aggred to terms and conditions.");
            }

            if (result.hasErrors()) {
                System.out.println(result.toString());
                model.addAttribute("user", user);
                return "signup";
            }

            user.setRole("ROLE_USER");
            user.setActive(true);
            user.setPassword(passwordEncoder.encode(user.getPassword()));

            userRepository.save(user);

            Message errorMessage = new Message("Successfully registered", "alert-success");
            model.addAttribute("message", errorMessage);
            model.addAttribute("user", new User());
            return "signup";

        } catch (Exception e) {
            e.printStackTrace();

            Message errorMessage = new Message("Something went wrong", "alert-danger");
            model.addAttribute("message", errorMessage);
            model.addAttribute("user", user);
            return "signup";
        }

    }

}
