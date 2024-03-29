package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String homeController(){
        System.out.println("In home controller....");
        return "index";
    }

    @RequestMapping("/about")
    public String aboutController() {
        System.out.println("In about controller....");
        return "about";
    }
    
}
