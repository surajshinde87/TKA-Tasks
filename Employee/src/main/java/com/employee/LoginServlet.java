package com.employee;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String email = request.getParameter("email");
    	String mob = request.getParameter("phone");
		Long phone = Long.parseLong(mob);

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

            String sql = "select * from employee_data2 where email=? and phone=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setLong(2, phone);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // login success
                response.sendRedirect("profile.jsp");
            } else {
                response.getWriter().println("Invalid Email or Phone NO!");
            }
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

