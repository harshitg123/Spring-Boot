package com.springboot.springbootmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homeController() {
        System.out.println("Inside home controller....");
        return "home";
    }

    @GetMapping("/test")
    @ResponseBody
    public String TestController() {
        System.out.println("Inside test controller.....");
        int a = 34;
        int b = 44;
        int c = 24;
        int d = 33;
        return "Sum of integers are " + (a + b + c + d);
    }
}
