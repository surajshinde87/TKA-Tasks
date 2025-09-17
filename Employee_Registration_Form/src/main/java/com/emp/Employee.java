package com.emp;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/register-employee")
public class Employee extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		  String empId = request.getParameter("empId");
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
	        float salary = Float.parseFloat(salary1);
	        String pan = request.getParameter("pan");
	        String aadhaarNo = request.getParameter("aadhaar");
	        Long aadhaar = Long.parseLong(aadhaarNo);
	        String bankAccount = request.getParameter("bankAccount");
	        String ifsc = request.getParameter("ifsc");
	        
	        System.out.println("=== Employee Registration Details ===");
	        System.out.println("Employee ID: " + empId);
	        System.out.println("Full Name: " + fullName);
	        System.out.println("Date of Birth: " + dob);
	        System.out.println("Gender: " + gender);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + phone);
	        System.out.println("Address: " + address);
	        System.out.println("Department: " + department);
	        System.out.println("Designation: " + designation);
	        System.out.println("Date of Joining: " + doj);
	        System.out.println("Monthly Salary: " + salary);
	        System.out.println("PAN Number: " + pan);
	        System.out.println("Aadhaar Number: " + aadhaar);
	        System.out.println("Bank Account Number: " + bankAccount);
	        System.out.println("IFSC Code: " + ifsc);



		
	}

}
