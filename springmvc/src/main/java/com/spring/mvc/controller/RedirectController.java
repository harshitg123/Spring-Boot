package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestParam;



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
        redirectView.setUrl("second"); // or you can use external url as well "https://www.google.com"
        return redirectView;
    }

    // Redirect using HttpServletResponse (not recommended way in spring mvc)
    @RequestMapping(path = "/redirectViaHttp", method=RequestMethod.GET)
    public String redirectUsingHttp(HttpServletResponse httpServletResponse) {
        try {
            httpServletResponse.sendRedirect("contact");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "";
    }
    
    
    
    @RequestMapping(path = "/second", method=RequestMethod.GET)
    public String requestMethodName() {
        System.out.println("Inside second handeler.....");
        return "contact";
    }
    
    
}