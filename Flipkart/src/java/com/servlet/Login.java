/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ACCESS
 */
@WebServlet("/loginpage")
public class Login extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request ,HttpServletResponse response)throws IOException ,ServletException{
        response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        
        RequestDispatcher req=request.getRequestDispatcher("Login.html");
        req.forward(request,response);
        out.println(req);
    }
    
}
