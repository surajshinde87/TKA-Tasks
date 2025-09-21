package com.jbk;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Student {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
	    System.out.println("Driver Loaded");
		
   Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","root");
   
    Statement s    = c.createStatement();
    
    int a = s.executeUpdate("insert into  student(id, name, email) values(7, 'suraj', 'suraj@gmail.com')");
    
    if (a > 0) {
    	System.out.println("Data is inserted");
	}else {
		System.out.println("Data is not  inserted");
	}
    
    c.close();
    
	}

}
