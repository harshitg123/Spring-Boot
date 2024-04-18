package com.thymleaf.thymeleaf.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IteratorConroller {

    @GetMapping("/loop")
    public String printLoopData(Model model) {

        List<String> friends = List.of("Harshit", "Ayush", "Kuljeet");
        model.addAttribute("friends", friends);
        return "iterator";
    }

    @GetMapping("/conditional")
    public String conditionalStatementString(Model model) {

        model.addAttribute("isActive", true);
        model.addAttribute("gender", "F");

        List<String> friends = List.of("harshit", "Ayush");
        model.addAttribute("friends", friends);

        return "conditional";
    }

    @GetMapping("/template")
    public String getTemplate(Model model) {
        model.addAttribute("title", "This is title");
        model.addAttribute("subtitle", "This is subtitle");
        return "templatePage";
    }

}
