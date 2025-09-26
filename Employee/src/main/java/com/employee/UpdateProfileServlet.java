package com.employee;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/updateProfile")
@MultipartConfig(maxFileSize = 2097152)
public class UpdateProfileServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int empId = Integer.parseInt(request.getParameter("empId"));
        String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");
        long phone = Long.parseLong(request.getParameter("phone"));
        String address = request.getParameter("address");
        String department = request.getParameter("department");
        String designation = request.getParameter("designation");

        Part filePart = request.getPart("profileImage");
        InputStream inputStream = null;
        if(filePart != null && filePart.getSize() > 0) {
            inputStream = filePart.getInputStream();
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee","root","root");

            String sql;
            if(inputStream != null){
                sql = "UPDATE employee_data2 SET fullName=?, email=?, phone=?, address=?, department=?, designation=?, profileImage=? WHERE empId=?";
            } else {
                sql = "UPDATE employee_data2 SET fullName=?, email=?, phone=?, address=?, department=?, designation=? WHERE empId=?";
            }

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, fullName);
            ps.setString(2, email);
            ps.setLong(3, phone);
            ps.setString(4, address);
            ps.setString(5, department);
            ps.setString(6, designation);

            if(inputStream != null) {
                ps.setBlob(7, inputStream);
                ps.setInt(8, empId);
            } else {
                ps.setInt(7, empId);
            }

            int row = ps.executeUpdate();
            if(row > 0){
                response.getWriter().println("<script>alert('Profile updated successfully!');"
                        + "window.location='profile.jsp';</script>");
            } else {
                response.getWriter().println("<script>alert('Update failed!'); window.history.back();</script>");
            }

            conn.close();

        } catch(Exception e){
            response.getWriter().println("<script>alert('Error: " + e.getMessage() + "'); window.history.back();</script>");
        }
    }
}
