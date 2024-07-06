package com.servlet;

import java.io.*;
import java.sql.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;



@WebServlet("/submit-form")
public class ReadProduct extends HttpServlet {
      
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String jdbcUrl = "jdbc:mysql://localhost:3306/admin";
        String dbUsername = "root";
        String dbPassword = "123@Root";
        String sql = "SELECT * FROM Products";
       
       
           
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            try (Connection conn = DriverManager.getConnection(jdbcUrl, dbUsername, dbPassword);
                 PreparedStatement stmt = conn.prepareStatement(sql);
                 ResultSet rs = stmt.executeQuery()) {

                StringBuilder htmlContent = new StringBuilder();
                htmlContent.append("<!DOCTYPE html>");
                htmlContent.append("<html lang=\"en\">");
                htmlContent.append("<head><meta charset=\"UTF-8\"><title>Product List</title></head>");
                htmlContent.append("<body style=\"background-color: gray; display:flex; justify-content:center\">");
                htmlContent.append("<div style=\"height:500px;width:500px;color:whitesmoke\">");
                htmlContent.append("<h1 style=\"margin-left:40px;color:green;\">Product List</h1>");
                htmlContent.append("<ol>");

                while (rs.next()) {
                   
                    
                    
                    
                    String productName = rs.getString("Product_name");
                    String productPrice = rs.getString("Product_price");
                    String productCategory = rs.getString("Product_category");
                    String productDescription = rs.getString("Product_desription");
                    String productImage = rs.getString("Product_Image"); 
                    String productCompany = rs.getString("Product_company");
                   htmlContent.append("<li style=\"padding:10px\">")
                               .append("Name: ").append(productName).append("<br/>")
                               .append("Price: ").append(productPrice).append("<br/>")
                               .append("Category: ").append(productCategory).append("<br/>")
                                .append("Image: ").append(productImage).append("<br/>")
                                .append("Description: ").append(productDescription).append("<br/>")
                                .append("CompanyName: ").append(productCompany)
                               .append("</li>");
                }

                htmlContent.append("</ol>");
                htmlContent.append("</div>");
                htmlContent.append("</body></html>");

                response.setContentType("text/html");
                PrintWriter out = response.getWriter();
                out.println(htmlContent.toString());
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
            throw new ServletException("Database access error", e);
        }
       
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Same as your existing doPost method implementation
        doGet(request, response); // Forward POST requests to doGet for processing
    }
}
