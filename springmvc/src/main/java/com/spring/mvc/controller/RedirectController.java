package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;


/**
 * RedirectController
 */

@Controller
public class RedirectController {

    // Redirecct using redirect prefix
    @RequestMapping(path = "/first", method=RequestMethod.GET)
    public String first() {
        System.out.println("inside first handeler......");
        return "redirect:/second";
    }

    // Redirect using redirectView
    @RequestMapping(path = "/redirect", method=RequestMethod.GET)
    public RedirectView redirect() {
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("second");
        return redirectView;
    }
    
    
    @RequestMapping(path = "/second", method=RequestMethod.GET)
    public String requestMethodName() {
        System.out.println("Inside second handeler.....");
        return "contact";
    }
    
    
}