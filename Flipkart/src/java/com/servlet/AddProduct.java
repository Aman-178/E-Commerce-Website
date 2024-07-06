package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@WebServlet("/addproduct")
@MultipartConfig(maxFileSize = 16177215)  
public class AddProduct extends HttpServlet {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/admin";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "123@Root";
    private Connection con;

    @Override
    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
            if (con != null) {
                System.out.println("Connected to database successfully");
            } else {
                System.out.println("Failed to connect to database");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String productName = request.getParameter("productname");
        String productPrice = request.getParameter("productprice");
        String productCategory = request.getParameter("category");
        String productDescription = request.getParameter("description");
        String ProductImage = request.getParameter("productimage");
        String companyName = request.getParameter("companyname");

        
        
        
                 try {
                        String sql = "INSERT INTO Products (Product_name, Product_price, Product_category,Product_desription,Product_image,Product_company) VALUES (?, ?, ?,?, ?,?)";
                        

                        try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
                            
                            preparedStatement.setString(1, productName);
                            preparedStatement.setString(2, productPrice);
                            preparedStatement.setString(3, productCategory);
                            preparedStatement.setString(4, productDescription);
                            preparedStatement.setString(5, ProductImage);
                            preparedStatement.setString(6, companyName);
                            
                         

                            int rowsInserted = preparedStatement.executeUpdate();
                            if (rowsInserted > 0) {

                                out.println("<h1>Product Add successful!</h1>");
                                
                                
                               
                            } else {
                                out.println("<h3>Product Add failed. Please try again.</h3>");
                            }
                        }
                    } catch (SQLException ex ) {
                        out.println("<h3>Error: Product Add failed. Please try again later.</h3>");
                        ex.printStackTrace();
                    }
    }

    @Override
    public void destroy() {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println("Error Occurred When Closing Database Connection");
            }
        }
    }
}
