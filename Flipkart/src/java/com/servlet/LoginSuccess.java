package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.Date;



@WebServlet("/LoginSuccess")
public class LoginSuccess extends HttpServlet {

    private static final String jdbcUser = "root";
    private static final String jdbcPassword = "123@Root";
    private static final String jdbcUrl = "jdbc:mysql://localhost:3306/admin";

    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
            if (con != null) {
                System.out.println("Successfully connected to database");
            } else {
                System.out.println("Database connection is null");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error in database connection: " + ex.getMessage());
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String userName = request.getParameter("email");
        String password = request.getParameter("password");

        String sql = "SELECT * FROM Authentican WHERE username = ? AND password = ?";
        PreparedStatement pstmt;
        ResultSet rs;
          try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, userName);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();
          
            if (rs.next()) {
                // Store user information in session
                HttpSession session = request.getSession();
                session.setAttribute("username", userName);
                Date createTime=new Date(session.getCreationTime());

                System.out.println(createTime);
                System.out.println("username:"+userName);

                response.sendRedirect("index.html");
              
            } else {
                // Send a response indicating login failed
             response.sendRedirect("Login.html?error=Invalid%20Email%20OR%20Password");

            }
            
            pstmt.close();
            rs.close();
            
        } catch (SQLException ex) {
            System.out.println("Error in Connection");
            // Send a response indicating error
            out.write("error");
        }
                      
            
            
            
       
    }
    
    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close(); // Close the connection when servlet is destroyed
            }
        } catch (SQLException ex) {
            System.out.println("Database connection can't be close");
        }
    }
}


