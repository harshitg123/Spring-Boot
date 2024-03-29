package controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;



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

    @RequestMapping("/help")
    public ModelAndView help() {
        System.out.println("In help controller.....");

        ModelAndView modelAndView = new ModelAndView();

        // Setting view name to show
        modelAndView.setViewName("help");

        // setting data for the view
        modelAndView.addObject("name", "Sabestian Klien");
        LocalDateTime now = LocalDateTime.now();
        modelAndView.addObject("time", now);

        List<Integer> num = new ArrayList<>();

        num.add(22);
        num.add(67);
        num.add(99);
        num.add(86);

        modelAndView.addObject("marks", num);

        return modelAndView;
    }
    
    
}
