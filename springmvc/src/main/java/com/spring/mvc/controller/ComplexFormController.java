package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.mvc.model.ComplexForm;


@Controller
public class ComplexFormController {
    
    @RequestMapping(path = "/complexForm", method=RequestMethod.GET)
    public String complexForm() {
        return "complexForm";
    }

    @RequestMapping(path = "/submitComplexForm", method=RequestMethod.POST)
    public String submitComplexForm(@ModelAttribute("complexForm") ComplexForm complexForm, BindingResult bindingResult, Model model) {
        System.out.println(complexForm.toString());

        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", "true");
            return "complexForm";
        }

        return "complexFormSuccess";
    }
    
    

}
