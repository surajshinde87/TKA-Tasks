package com.student;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@WebServlet("/submit-student")
public class Student extends HttpServlet {

	
 @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	String name = req.getParameter("name");
	String age = req.getParameter("age");
	int age1 = Integer.parseInt(age);
	String city = req.getParameter("city");
	String mob = req.getParameter("mobile");
	long phone = Long.parseLong(mob);
	
	System.out.println(name);
	System.out.println(age1);
	System.out.println(city);
	System.out.println(phone);
	 
}
	

}
