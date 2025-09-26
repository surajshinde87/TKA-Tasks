package com.employee;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
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

@WebServlet("/register-employee")
@MultipartConfig(maxFileSize = 2097152)
public class Employee extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String empId1 = request.getParameter("empId");
		Integer empId = Integer.parseInt(empId1);
		String fullName = request.getParameter("fullName");
		String dob = request.getParameter("dob");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String mob = request.getParameter("phone");
		Long phone = Long.parseLong(mob);
		String address = request.getParameter("address");
		String department = request.getParameter("department");
		String designation = request.getParameter("designation");
		String doj = request.getParameter("doj");
		String salary1 = request.getParameter("salary");
		Float salary = Float.parseFloat(salary1);
		String pan = request.getParameter("pan");
		String aadhaarNo = request.getParameter("aadhaar");
		Long aadhaar = Long.parseLong(aadhaarNo);
		String bankAccountNo = request.getParameter("bankAccount");
		Long bankAccount = Long.parseLong(bankAccountNo);
		String ifsc = request.getParameter("ifsc");
		String password = request.getParameter("password");
		Part filePart = request.getPart("profileImage");
		InputStream inputStream = null;
		if (filePart != null && filePart.getSize() > 0) {
			inputStream = filePart.getInputStream();
		}

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			String insertQuery = "INSERT INTO employee_data2 (empId, fullName, dob, gender, email, phone, address, department, designation, doj, salary, pan, aadhaar, bankAccount, ifsc, password, profileImage) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(insertQuery);

			ps.setInt(1, empId);
			ps.setString(2, fullName);
			ps.setString(3, dob);
			ps.setString(4, gender);
			ps.setString(5, email);
			ps.setLong(6, phone);
			ps.setString(7, address);
			ps.setString(8, department);
			ps.setString(9, designation);
			ps.setString(10, doj);
			ps.setFloat(11, salary);
			ps.setString(12, pan);
			ps.setLong(13, aadhaar);
			ps.setLong(14, bankAccount);
			ps.setString(15, ifsc);
			ps.setString(16, password);

			if (inputStream != null) {
				ps.setBlob(17, inputStream);
			} else {
				ps.setNull(17, java.sql.Types.BLOB);
			}

			int row = ps.executeUpdate();

			if (row > 0) {
				out.println("<script>alert('Employee registered successfully!');"
						+ "window.location='login.html';</script>");
			} else {
				out.println(
						"<script>alert('Registration failed! Please try again.');" + "window.history.back();</script>");
			}

		} catch (Exception e) {
			out.println("<script>alert('Error: " + e.getMessage() + "');" + "window.history.back();</script>");
		}

	}

}
