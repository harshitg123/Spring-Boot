package com.springvalidation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.springvalidation.Entity.LoginData;

import jakarta.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("loginData", new LoginData());
        System.out.println("Form Controller");
        return "formPage";
    }

    @PostMapping("/submit")
    public String processForm(@Valid @ModelAttribute("loginData") LoginData loginData, BindingResult result) {

        if (result.hasErrors()) {
            System.out.println(result);
            return "formPage";
        }

        System.out.println(loginData);
        return "success";
    }

}
