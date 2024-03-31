package com.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.mvc.model.User;
import com.spring.mvc.service.UserService;



@Controller
public class ContactController {

    @Autowired
    private UserService userService;

    // We can specify redudent code in on mwthod with the help of ModelAttribute which will run each time we hit
    // any endpoint and add the attribute in model

    @ModelAttribute
    public void commonData(Model model){
        model.addAttribute("username", "Harshit Gupta");
        model.addAttribute("appName", "Test application");
        System.out.println("Adding common data to model......");
    }

    
    @RequestMapping(path = "/contact", method=RequestMethod.GET)
    public String contactDetails() {
        return "contact";
    }

    // @RequestMapping(path = "/processForm", method=RequestMethod.POST)
    // public String requestMethodName(
    //     @RequestParam("email") String userEmail,
    //     @RequestParam("username") String userName,
    //     @RequestParam("password") String userPassword, Model model) {

    //     System.out.println(userEmail);
    //     System.out.println(userName);
    //     System.out.println(userPassword);

    //     model.addAttribute("email", userEmail);
    //     model.addAttribute("password", userPassword);
    //     model.addAttribute("name", userName);

    //     return "success";
    // }

    // @RequestMapping(path = "/processForm", method=RequestMethod.POST)
    // public String requestMethodName(
    //     @RequestParam("email") String userEmail,
    //     @RequestParam("username") String userName,
    //     @RequestParam("password") String userPassword, Model model) {

    //     User user = new User();

    //     user.setEmail(userEmail);
    //     user.setPassword(userPassword);
    //     user.setUsername(userName);

    //     System.out.println(user);

    //     model.addAttribute("user", user);

    //     return "success";
    // }

    // @ModelAttribute will map the form fields with the model variables
    @RequestMapping(path = "/processForm", method=RequestMethod.POST)
    public String requestMethodName(@ModelAttribute User user, Model model) {
        System.out.println(user);
        Long id = this.userService.createUser(user);
        model.addAttribute("Id", id);
        return "success";
    }
    
    
}
