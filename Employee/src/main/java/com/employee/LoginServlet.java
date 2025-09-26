package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
   
	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        String email = request.getParameter("email");
    	String password = request.getParameter("password");
    	
    	PrintWriter out = response.getWriter();

        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

            String sql = "SELECT * FROM employee_data2 WHERE email=? and password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
            	
            	HttpSession session = request.getSession();
                session.setAttribute("empId", rs.getInt("empId"));
                session.setAttribute("fullName", rs.getString("fullName"));
                session.setAttribute("dob", rs.getString("dob"));
                session.setAttribute("gender", rs.getString("gender"));
                session.setAttribute("email", rs.getString("email"));
                session.setAttribute("phone", rs.getLong("phone"));
                session.setAttribute("address", rs.getString("address"));
                session.setAttribute("department", rs.getString("department"));
                session.setAttribute("designation", rs.getString("designation"));
                session.setAttribute("doj", rs.getString("doj"));
                session.setAttribute("salary", rs.getFloat("salary"));
                session.setAttribute("pan", rs.getString("pan"));
                session.setAttribute("aadhaar", rs.getLong("aadhaar"));
                session.setAttribute("bankAccount", rs.getLong("bankAccount"));
                session.setAttribute("ifsc", rs.getString("ifsc"));
                response.sendRedirect("profile.jsp");
                
            } else {
            	response.setContentType("text/html");
                out.println("<script type=\"text/javascript\">");
                out.println("alert('Invalid Email or Password');");
                out.println("location='login.html';"); 
                out.println("</script>");
            }
        } catch (Exception e) {
            response.getWriter().println("Error: " + e.getMessage());
        }
    }
}

