package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    
    @RequestMapping(name = "/home")
    public String homeController(){
        System.out.println("In home controller....");
        return "index";
    }
}
