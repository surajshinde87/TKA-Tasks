package com.emp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register-employee")
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

		PrintWriter out = response.getWriter();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee", "root", "root");

			String insertQuery = "insert into employee_data2 (empId, fullName, dob, gender, email, phone, address, department, designation, doj, salary, pan, aadhaar, bankAccount, ifsc) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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

			int row = ps.executeUpdate(); 
			
			if(row > 0) {
				out.println("<html>");
				out.println("<head><title>Employee Details</title></head>");
				out.println("<body>");
				out.println("<h1>Employee Details</h1>");

				out.println("Employee ID : " + empId + "<br>");
				out.println("Full Name : " + fullName + "<br>");
				out.println("Date of Birth : " + dob + "<br>");
				out.println("Gender : " + gender + "<br>");
				out.println("Email : " + email + "<br>");
				out.println("Phone : " + phone + "<br>");
				out.println("Address : " + address + "<br>");
				out.println("Department : " + department + "<br>");
				out.println("Designation : " + designation + "<br>");
				out.println("Date of Joining : " + doj + "<br>");
				out.println("Salary : " + salary + "<br>");
				out.println("PAN No. : " + pan + "<br>");
				out.println("Aadhaar No. : " + aadhaar + "<br>");
				out.println("Bank Account No. : " + bankAccount + "<br>");
				out.println("IFSC Code : " + ifsc + "<br>");

				out.println("</body>");
				out.println("</html>");


				   
			}else {
				out.println("Data Not inserted");
			}
			

		} catch (Exception e) {
			out.println("Error Occured : " + e.getMessage());
		}

	}

}
