package com.thymleaf.thymeleaf.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IteratorConroller {

    @GetMapping("/loop")
    public String printLoopData(Model model) {

        List<String> friends = List.of("Harshit", "Ayush", "Kuljeet");
        model.addAttribute("friends", friends);
        return "iterator";
    }

}
