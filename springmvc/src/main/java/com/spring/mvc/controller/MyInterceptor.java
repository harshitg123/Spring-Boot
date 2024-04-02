package com.spring.mvc.controller;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyInterceptor implements HandlerInterceptor{

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("pre intercept.....");
        String st = request.getParameter("userName");

        if (st.startsWith("p")) {
            response.setContentType("text/html");
            response.getWriter().println("<h2>Please enter the valid name...... It should not start with P</h2>");
            return false;
        }

        return true;
    }

    
}
