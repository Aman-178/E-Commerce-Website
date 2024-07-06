/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ACCESS
 */
@WebServlet("/updateproduct")
public class UpdateServlet extends HttpServlet {
    
    private static final String Jdbc_url = "jdbc:mysql://localhost:3306/admin";
    private static final String Jdbc_user = "root";
    private static final String Jdbc_Password = "123@Root";
    
    
    private Connection con;
      @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(Jdbc_url, Jdbc_user, Jdbc_Password);
            if (con != null) {
                System.out.println("Database connected Successfully");
            } else {
                System.out.println("Database connection is null");
            }
        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println("Error in database connection: " + ex.getMessage());
        }
    }
    
   @Override
public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();

    String id = request.getParameter("productid");
    String colname = request.getParameter("productcolumn");
    String value = request.getParameter("Productvalue");

    String sql = "update Products set " + colname + " = ? where id = ?";

    if (id != null && !id.isEmpty()
            && colname != null && !colname.isEmpty()
            && value != null && !value.isEmpty()) {

        try {
            int Id = Integer.parseInt(id);
            PreparedStatement pmt = con.prepareStatement(sql);
            pmt.setString(1, value);
            pmt.setInt(2, Id);

            int row = pmt.executeUpdate();
            if (row > 0) {
                response.sendRedirect("Admin.html");
            } else {
                out.println("Error in updating.");
            }

        } catch (SQLException | NumberFormatException ex) {
            Logger.getLogger(UpdateServlet.class.getName()).log(Level.SEVERE, null, ex);
            out.println("Error: " + ex.getMessage());
        }

    } else {
        out.println("Please provide all parameters.");
    }
}

    
      @Override
    public void destroy() {
        // Close database connection
        try {
            if (con != null && !con.isClosed()) {
                con.close();
                System.out.println("Database connection closed.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
