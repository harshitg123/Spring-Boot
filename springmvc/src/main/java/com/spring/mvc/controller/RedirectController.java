package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * RedirectController
 */

@Controller
public class RedirectController {

    @RequestMapping(path = "/first", method=RequestMethod.GET)
    public String first() {
        System.out.println("inside first handeler......");
        return "redirect:/second";
    }
    
    @RequestMapping(path = "/second", method=RequestMethod.GET)
    public String requestMethodName() {
        System.out.println("Inside second handeler.....");
        return "contact";
    }
    
    
}