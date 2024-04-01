package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class PathVariableController {
    
    @RequestMapping(path = "/pathVariable/{userId}", method=RequestMethod.GET)
    public String pathVariable(@PathVariable("userId") int userId) {

        System.out.println(userId);
        return "complexForm";
    }
    
}
