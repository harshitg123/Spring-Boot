package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class HomeController {
    
    @RequestMapping("/home")
    public String homeController(Model model){

        model.addAttribute("name", "Harshit Gupta");
        model.addAttribute("Id", 5554);

        List<String> friends = new ArrayList<String>();

        friends.add("Ayush");
        friends.add("Kuljeet");
        friends.add("Mahi");

        model.addAttribute("friends", friends);

        System.out.println("In home controller....");
        return "index";
    }

    @RequestMapping("/about")
    public String aboutController() {
        System.out.println("In about controller....");
        return "about";
    }
    
}
