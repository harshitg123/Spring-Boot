package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class ContactController {
    
    @RequestMapping(path = "/contact", method=RequestMethod.GET)
    public String contactDetails() {
        return "contact";
    }

    @RequestMapping(path = "/processForm", method=RequestMethod.POST)
    public void requestMethodName(@RequestParam String param) {
     
    }
    
    
}
