package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet("/SignUpForm")
public class SignupServlet extends HttpServlet {
    
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String Username = request.getParameter("email");
        String Password = request.getParameter("password");
        String ConfirmPassword = request.getParameter("confirmpassword");
        
        if (Password.equals(ConfirmPassword)) {
            String sql = "INSERT INTO Authentican(username, password) VALUES (?, ?)";
            try {
                PreparedStatement pmt = con.prepareStatement(sql);
                pmt.setString(1, Username);
                pmt.setString(2, Password); // Use parameter index 2 for password
                
                int rowsInserted = pmt.executeUpdate();
                if (rowsInserted > 0) {
                    response.sendRedirect("index.html");
                }
            } catch (SQLException ex) {
                Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } else {
            response.sendRedirect("SignUp.html?error=Password%20Doesn%27t%20Match");
            
        }
    }
    
    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close(); // Close the connection when servlet is destroyed
            }
        } catch (SQLException ex) {
            Logger.getLogger(SignupServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
