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

@WebServlet("/displayImage")
public class DisplayImageServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        String empIdStr = request.getParameter("empId");
        if(empIdStr == null) return;

        int empId = Integer.parseInt(empIdStr);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/employee", "root", "root");

            String sql = "SELECT profileImage FROM employee_data2 WHERE empId=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, empId);
            ResultSet rs = ps.executeQuery();

            if(rs.next()) {
                byte[] imgBytes = rs.getBytes("profileImage");
                if(imgBytes != null) {
                    response.setContentType("image/jpeg"); // or "image/png"
                    response.getOutputStream().write(imgBytes);
                }
            }

            rs.close();
            ps.close();
            conn.close();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}

