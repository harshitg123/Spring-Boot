package com.springvalidation.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StaticController {

    @GetMapping("/static")
    public String page() {
        return "staticStylePage";
    }

}
