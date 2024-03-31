package com.spring.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;


@Controller
public class SearchController {
    
    @RequestMapping(path = "/searchForm", method=RequestMethod.GET)
    public String search() {
        System.out.println("In search controller.....");
        return "searchPage";
    }

    @RequestMapping(path = "/search", method=RequestMethod.POST)
    public RedirectView requestMethodName(@RequestParam("search") String query) {

        String url = "https://www.google.com/search?q=" + query;
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl(url);   

        return redirectView;
    }
    
    
}
