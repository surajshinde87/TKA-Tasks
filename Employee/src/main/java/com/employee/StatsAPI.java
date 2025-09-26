package com.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/getStats")
public class StatsAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("application/json");
        PrintWriter out = response.getWriter();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/employee", "root", "root");

            // Total Employees
            Statement stmtEmp = conn.createStatement();
            ResultSet rsEmp = stmtEmp.executeQuery("SELECT COUNT(*) AS totalEmployees FROM employee_data2");
            int totalEmployees = 0;
            if (rsEmp.next()) {
                totalEmployees = rsEmp.getInt("totalEmployees");
            }
            rsEmp.close();
            stmtEmp.close();

            // Total Departments
            Statement stmtDept = conn.createStatement();
            ResultSet rsDept = stmtDept.executeQuery("SELECT COUNT(DISTINCT department) AS totalDepartments FROM employee_data2");
            int totalDepartments = 0;
            if (rsDept.next()) {
                totalDepartments = rsDept.getInt("totalDepartments");
            }
            rsDept.close();
            stmtDept.close();

            // Average Salary
            Statement stmtSalary = conn.createStatement();
            ResultSet rsSalary = stmtSalary.executeQuery("SELECT AVG(salary) AS avgSalary FROM employee_data2");
            float avgSalary = 0;
            if (rsSalary.next()) {
                avgSalary = rsSalary.getFloat("avgSalary");
            }
            rsSalary.close();
            stmtSalary.close();

            String json = String.format(
                "{\"totalEmployees\":%d, \"totalDepartments\":%d, \"avgSalary\":%.2f}",
                totalEmployees, totalDepartments, avgSalary
            );

            out.write(json);
            conn.close();

        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            out.write("{\"error\":\"" + e.getMessage() + "\"}");
        }
    }

}
