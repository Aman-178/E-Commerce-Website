
package com.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



@WebServlet("/FetchData")
public class JsonData extends HttpServlet {

  

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/admin";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "123@Root";

    private Connection con;

    @Override
    public void init() throws ServletException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(JDBC_URL, DB_USERNAME, DB_PASSWORD);
            if(con!=null){
                System.out.println("Database Successfully Connected");
            }else{
                out.println("Database is null");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new ServletException("Database Connection Error", ex);
        }
    }

    
    
//    @Override
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    response.setContentType("application/json");
//    PrintWriter out = response.getWriter();
//
//    // Initialize variables
//   
//    String[] selectedLaptops = request.getParameterValues("Laptops");
//    String[] selectedMobile=request.getParameterValues("Mobiles");
//    String[] selectedPrices=request.getParameterValues("Prices");
//    String searchTerm = request.getParameter("searchTerm");
//      ArrayList<DataList> List = new ArrayList<>();
//
//    try {
//        // Prepare SQL statement
//      
//       PreparedStatement  pmt;
//       String  sql;
//          if (searchTerm != null && !searchTerm.isEmpty()) {
//        // If searchTerm is provided, construct SQL query for searching by name, category, or company
//        sql = "SELECT * FROM Products WHERE Product_name LIKE ? OR Product_category LIKE ? OR Product_company LIKE ?";
//        pmt = con.prepareStatement(sql);
//        String likeTerm = "%" + searchTerm + "%";
//        pmt.setString(1, likeTerm);
//        pmt.setString(2, likeTerm);
//        pmt.setString(3, likeTerm);
//    } else if ((selectedLaptops != null && selectedLaptops.length > 0) ||
//               (selectedMobile != null && selectedMobile.length > 0) ||
//               (selectedPrices != null && selectedPrices.length > 0)) {
//        // If selectedLaptops, selectedMobiles, or selectedPrices are provided, construct the query accordingly
//        StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Products WHERE ");
//        ArrayList<String> conditions = new ArrayList<>();
//
//        if (selectedLaptops != null && selectedLaptops.length > 0) {
//            conditions.add("Product_company IN (" + buildInClause(selectedLaptops.length) + ")");
//        }
//        if (selectedMobile != null && selectedMobile.length > 0) {
//            conditions.add("Product_company IN (" + buildInClause(selectedMobile.length) + ")");
//        }
//        if (selectedPrices != null && selectedPrices.length > 0) {
//            StringBuilder priceConditions = new StringBuilder();
//            priceConditions.append("(");
//            for (int i = 0; i < selectedPrices.length; i++) {
//                if (i > 0) {
//                    priceConditions.append(" OR ");
//                }
//                priceConditions.append("Product_price < ?");
//            }
//            priceConditions.append(")");
//            conditions.add(priceConditions.toString());
//        }
//
//        sqlBuilder.append(String.join(" OR ", conditions));
//        sql = sqlBuilder.toString();
//        pmt = con.prepareStatement(sql);
//
//        int paramIndex = 1;
//        if (selectedLaptops != null && selectedLaptops.length > 0) {
//            for (String laptop : selectedLaptops) {
//                pmt.setString(paramIndex++, laptop);
//            }
//        }
//        if (selectedMobile != null && selectedMobile.length > 0) {
//            for (String mobile : selectedMobile) {
//                pmt.setString(paramIndex++, mobile);
//            }
//        }
//        if (selectedPrices != null && selectedPrices.length > 0) {
//            for (String price : selectedPrices) {
//                pmt.setString(paramIndex++, price);
//            }
//        }
//    } else {
//        // If no specific search criteria provided, fetch all data
//        sql = "SELECT * FROM Products";
//        pmt = con.prepareStatement(sql);
//    }
//                
//            
//        // Execute query
//        ResultSet rs=pmt.executeQuery();
//        while(rs.next()){
//                      String Name=rs.getString("Product_name");
//                      String Price=rs.getString("Product_price");
//                      String Category=rs.getString("Product_category");
//                      String Description=rs.getString("Product_desription");
//                      String Image=rs.getString("Product_image");
//                      
//                      
//                      DataList obj=new DataList();
//                      obj.SetProductName(Name);
//                      obj.SetProductPrice(Price);
//                      obj.SetProductCategory(Category);
//                      obj.SetProductDescription(Description);
//                      obj.SetProductImage(Image);
//                      
//                      List.add(obj);
//                  }
//
//        // Convert list to JSON using Gson
//        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson(List);
//
//        // Send JSON response
//        out.println(json);
//
//    } catch (SQLException ex) {
//        // Handle database errors
//        ex.printStackTrace();
//        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        out.println("Error fetching data from database");
//    }
//    
//    
//   
//}
//private String buildInClause(int length) {
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < length; i++) {
//        sb.append("?");
//        if (i < length - 1) {
//            sb.append(",");
//        }
//    }
//    return sb.toString();
//}
    






















//@Override
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//    response.setContentType("application/json");
//    PrintWriter out = response.getWriter();
//
//    // Get filter parameters
//    String[] selectedLaptops = request.getParameterValues("Laptops");
//    String[] selectedMobile = request.getParameterValues("Mobiles");
//    String[] selectedPrices = request.getParameterValues("Prices");
//    String searchTerm = request.getParameter("searchTerm");
//    ArrayList<DataList> List = new ArrayList<>();
//
//    try {
//        // Prepare SQL statement
//        String sql;
//        PreparedStatement pmt;
//
//        if (searchTerm != null && !searchTerm.isEmpty()) {
//            // If searchTerm is provided, construct SQL query for searching by name, category, or company
//            sql = "SELECT * FROM Products WHERE Product_name LIKE ? OR Product_category LIKE ? OR Product_company LIKE ?";
//            pmt = con.prepareStatement(sql);
//            String likeTerm = "%" + searchTerm + "%";
//            pmt.setString(1, likeTerm);
//            pmt.setString(2, likeTerm);
//            pmt.setString(3, likeTerm);
//        } else {
//            // Construct the base SQL query
//            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Products WHERE 1=1");
//            ArrayList<String> conditions = new ArrayList<>();
//
//            if (selectedLaptops != null && selectedLaptops.length > 0) {
//                conditions.add("Product_company IN (" + buildInClause(selectedLaptops.length) + ")");
//            }
//            if (selectedMobile != null && selectedMobile.length > 0) {
//                conditions.add("Product_company IN (" + buildInClause(selectedMobile.length) + ")");
//            }
//            if (selectedPrices != null && selectedPrices.length > 0) {
//                StringBuilder priceConditions = new StringBuilder();
//                priceConditions.append("(");
//                for (int i = 0; i < selectedPrices.length; i++) {
//                    if (i > 0) {
//                        priceConditions.append(" OR ");
//                    }
//                    priceConditions.append("Product_price < ?");
//                }
//                priceConditions.append(")");
//                conditions.add(priceConditions.toString());
//            }
//
//            // Append all conditions with AND logic
//            if (!conditions.isEmpty()) {
//                sqlBuilder.append(" AND (");
//                sqlBuilder.append(String.join(" OR ", conditions));
//                sqlBuilder.append(")");
//            }
//
//            sql = sqlBuilder.toString();
//            pmt = con.prepareStatement(sql);
//
//            // Set parameters for prepared statement
//            int paramIndex = 1;
//            if (selectedLaptops != null && selectedLaptops.length > 0) {
//                for (String laptop : selectedLaptops) {
//                    pmt.setString(paramIndex++, laptop);
//                }
//            }
//            if (selectedMobile != null && selectedMobile.length > 0) {
//                for (String mobile : selectedMobile) {
//                    pmt.setString(paramIndex++, mobile);
//                }
//            }
//            if (selectedPrices != null && selectedPrices.length > 0) {
//                for (String price : selectedPrices) {
//                    pmt.setString(paramIndex++, price);
//                }
//            }
//        }
//
//        // Execute query
//        ResultSet rs = pmt.executeQuery();
//        while (rs.next()) {
//            String Name = rs.getString("Product_name");
//            String Price = rs.getString("Product_price");
//            String Category = rs.getString("Product_category");
//            String Description = rs.getString("Product_desription");
//            String Image = rs.getString("Product_image");
//
//            DataList obj = new DataList();
//            obj.SetProductName(Name);
//            obj.SetProductPrice(Price);
//            obj.SetProductCategory(Category);
//            obj.SetProductDescription(Description);
//            obj.SetProductImage(Image);
//
//            List.add(obj);
//        }
//
//        // Convert list to JSON using Gson
//        Gson gson = new GsonBuilder().create();
//        String json = gson.toJson(List);
//
//        // Send JSON response
//        out.println(json);
//
//    } catch (SQLException ex) {
//        // Handle database errors
//        ex.printStackTrace();
//        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
//        out.println("Error fetching data from database");
//    }
//}
//
//private String buildInClause(int length) {
//    StringBuilder sb = new StringBuilder();
//    for (int i = 0; i < length; i++) {
//        sb.append("?");
//        if (i < length - 1) {
//            sb.append(",");
//        }
//    }
//    return sb.toString();
//}

    
    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    response.setContentType("application/json");
    PrintWriter out = response.getWriter();

    // Get filter parameters
    String[] selectedLaptops = request.getParameterValues("Laptops");
    String[] selectedMobile = request.getParameterValues("Mobiles");
    String[] selectedPrices = request.getParameterValues("Prices");
    String searchTerm = request.getParameter("searchTerm");
    ArrayList<DataList> List = new ArrayList<>();

    try {
        // Prepare SQL statement
        String sql;
        PreparedStatement pmt;

        if (searchTerm != null && !searchTerm.isEmpty()) {
            // If searchTerm is provided, construct SQL query for searching by name, category, or company
            sql = "SELECT * FROM Products WHERE Product_name LIKE ? OR Product_category LIKE ? OR Product_company LIKE ?";
            pmt = con.prepareStatement(sql);
            String likeTerm = "%" + searchTerm + "%";
            pmt.setString(1, likeTerm);
            pmt.setString(2, likeTerm);
            pmt.setString(3, likeTerm);
        } else {
            // Construct the base SQL query
            StringBuilder sqlBuilder = new StringBuilder("SELECT * FROM Products WHERE 1=1");

            if (selectedLaptops != null && selectedLaptops.length > 0) {
                sqlBuilder.append(" AND Product_company IN (").append(buildInClause(selectedLaptops.length)).append(")");
            }
            if (selectedMobile != null && selectedMobile.length > 0) {
                sqlBuilder.append(" AND Product_company IN (").append(buildInClause(selectedMobile.length)).append(")");
            }
            if (selectedPrices != null && selectedPrices.length > 0) {
                sqlBuilder.append(" AND (");
                for (int i = 0; i < selectedPrices.length; i++) {
                    if (i > 0) {
                        sqlBuilder.append(" OR ");
                    }
                    sqlBuilder.append("Product_price <= ?");
                }
                sqlBuilder.append(")");
            }

            sql = sqlBuilder.toString();
            pmt = con.prepareStatement(sql);

            // Set parameters for prepared statement
            int paramIndex = 1;
            if (selectedLaptops != null && selectedLaptops.length > 0) {
                for (String laptop : selectedLaptops) {
                    pmt.setString(paramIndex++, laptop);
                }
            }
            if (selectedMobile != null && selectedMobile.length > 0) {
                for (String mobile : selectedMobile) {
                    pmt.setString(paramIndex++, mobile);
                }
            }
            if (selectedPrices != null && selectedPrices.length > 0) {
                for (String price : selectedPrices) {
                    pmt.setString(paramIndex++, price);
                }
            }
        }

        // Execute query
        ResultSet rs = pmt.executeQuery();
        while (rs.next()) {
            String Name = rs.getString("Product_name");
            String Price = rs.getString("Product_price");
            String Category = rs.getString("Product_category");
            String Description = rs.getString("Product_desription");
            String Image = rs.getString("Product_image");

            DataList obj = new DataList();
            obj.SetProductName(Name);
            obj.SetProductPrice(Price);
            obj.SetProductCategory(Category);
            obj.SetProductDescription(Description);
            obj.SetProductImage(Image);

            List.add(obj);
        }

        // Convert list to JSON using Gson
        Gson gson = new GsonBuilder().create();
        String json = gson.toJson(List);

        // Send JSON response
        out.println(json);

    } catch (SQLException ex) {
        // Handle database errors
        ex.printStackTrace();
        response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        out.println("Error fetching data from database");
    }
}

private String buildInClause(int length) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < length; i++) {
        sb.append("?");
        if (i < length - 1) {
            sb.append(",");
        }
    }
    return sb.toString();
}



}






















