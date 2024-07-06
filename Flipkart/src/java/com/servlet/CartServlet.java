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
@WebServlet("/checkout")
public class CartServlet extends HttpServlet{
    
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException{
        response.setContentType("Text/html");
        PrintWriter out=response.getWriter();
        
           StringBuilder htmlContent = new StringBuilder();
                htmlContent.append("<!DOCTYPE html>");
                htmlContent.append("<html lang=\"en\">");
                htmlContent.append("<head><meta charset=\"UTF-8\"><title>Product List</title></head>");
                htmlContent.append("<body style=\"background-color: gray; display:flex; justify-content:center\">");
        
                htmlContent.append("<h1>aman</h1>");
                           
                
                htmlContent.append("</body></html>");
                out.println(htmlContent.toString());
    }
    
}
