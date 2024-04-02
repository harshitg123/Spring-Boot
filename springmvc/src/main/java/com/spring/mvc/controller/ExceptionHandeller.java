package com.spring.mvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ExceptionHandeller {
    
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NumberFormatException.class)
    public String handelNumberFormatException(Model model){
        model.addAttribute("error", "Number Format Exception");
        return "handelErrorPage";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = NullPointerException.class)
    public String nullPointerException(Model model){

        model.addAttribute("error", "Null pointer exception");
        return "handelErrorPage";
    }

    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(value = Exception.class)
    public String handelAllErrors(Model model){
        model.addAttribute("error", "Exception occured");
        return "handelErrorPage";
    }

}
