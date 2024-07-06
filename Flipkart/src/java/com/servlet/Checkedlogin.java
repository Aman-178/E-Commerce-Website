package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;




@WebServlet("/LoginStatusServlet")
public class Checkedlogin extends HttpServlet {
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false); // Do not create a new session if one doesn't exist
        if (session != null && session.getAttribute("username") != null) {
            response.getWriter().write("loggedIn");
        
        } else {
            response.getWriter().write("notLoggedIn");
        }
    }
            
            
                  
    
}
