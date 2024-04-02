package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class InterceptorController {
    
    @RequestMapping(path = "/intercept", method=RequestMethod.GET)
    public String interceptForm() {
        return "interceptForm";
    }

    @RequestMapping(path = "/interceptorSucces", method=RequestMethod.POST)
    public String interceptSuccess(@RequestParam("userName") String name, Model model) {

        System.out.println(name);
        model.addAttribute("name", name);

        return "interceptorSucces";
    }
    

}
