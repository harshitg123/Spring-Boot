package com.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;


@Controller
public class PathVariableController {
    
    @RequestMapping(path = "/pathVariable/{userId}/{userName}", method=RequestMethod.GET)
    public String pathVariable(@PathVariable("userId") int userId, @PathVariable("userName") String userName) {

        int st = Integer.parseInt(userName);

        System.out.println(userId);
        return "complexForm";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NumberFormatException.class)
    public String handelNumberFormatException(Model model){
        model.addAttribute("error", "Number Format Exception");
        return "handelErrorPage";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String handelAllErrors(Model model){
        model.addAttribute("error", "Exception occured");
        return "handelErrorPage";
    }
    
}
