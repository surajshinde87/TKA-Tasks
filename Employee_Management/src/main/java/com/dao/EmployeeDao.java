package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class EmployeeDao {

	Scanner sc = new Scanner(System.in);
//	DataBase Connection

	public Connection connectDb() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			String url = "jdbc:mysql://localhost:3306/employee";
			String userName = "root";
			String password = "root";

			Connection conn = DriverManager.getConnection(url, userName, password);

			System.out.println("Database Connected Successfully");
			return conn;
		} catch (Exception e) {
			System.out.println("Something Error Occured During Connection " + e);
			return null;
		}

	}

//	Add Employee Data
	public void addEmployee() {
		Connection conn = connectDb();

		try {
			String addQuery = "insert into employee_data(id, firstName, lastName, email, phone, gender, department, salary, address) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement ps = conn.prepareStatement(addQuery);

			System.out.println("Enter Your Employee Id : ");
			int id = sc.nextInt();
			sc.nextLine(); // This if for new line

			System.out.println("Enter Your First Name: ");
			String firstName = sc.nextLine();

			System.out.println("Enter Your Last Name: ");
			String lastName = sc.nextLine();

			System.out.println("Enter Your Email: ");
			String email = sc.nextLine();

			System.out.println("Enter Your Phone: ");
			String phone = sc.nextLine();

			System.out.println("Enter Your Gender (Male/Female/Other): ");
			String gender = sc.nextLine();

			System.out.println("Enter Your Department: ");
			String department = sc.nextLine();

			System.out.println("Enter Your Salary: ");
			double salary = sc.nextDouble();
			sc.nextLine(); // This if for new line

			System.out.println("Enter Your Address: ");
			String address = sc.nextLine();

			// Set parameters
			ps.setInt(1, id);
			ps.setString(2, firstName);
			ps.setString(3, lastName);
			ps.setString(4, email);
			ps.setString(5, phone);
			ps.setString(6, gender);
			ps.setString(7, department);
			ps.setDouble(8, salary);
			ps.setString(9, address);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Employee data inserted successfully!");
			}


		} catch (SQLException e) {
			System.out.println("Failed to add Employee " + e);
		}

	}

	// Update Employee Data
	public void updateEmployee() {
		Connection conn = connectDb();

		try {
			String updateQuery = "update employee_data set department = ?, salary = ? where id = ?";
			PreparedStatement ps = conn.prepareStatement(updateQuery);

			System.out.println("Enter Employee id to Update Details: ");
			int id = sc.nextInt();
			sc.nextLine(); // This if for new line

			System.out.println("Enter Your New Department Name: ");
			String department = sc.nextLine();

			System.out.println("Enter Your Updated Salry: ");
			double salary = sc.nextDouble();
			sc.nextLine();

			ps.setString(1, department);
			ps.setDouble(2, salary);
			ps.setInt(3, id);

			int rowsInserted = ps.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("Employee data Updated successfully!");
			}

			
			conn.close();

		} catch (SQLException e) {
			System.out.println("Failed to Update Employee " + e);
		}

	}

// Get Single Employee
	public void getEmployee() {
		Connection conn = connectDb();

		try {

			String getEmpQuery = "select * from employee_data where id = ?";

			PreparedStatement ps = conn.prepareStatement(getEmpQuery);
			System.out.println("Enter Employee id to Get Details: ");
			int id = sc.nextInt();
			sc.nextLine();
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				System.out.println("Employee Details for id " + rs.getInt("id"));
				System.out.println("First Name: " + rs.getString("firstName"));
				System.out.println("Last Name: " + rs.getString("lastName"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
				System.out.println("Gender: " + rs.getString("gender"));
				System.out.println("Department: " + rs.getString("department"));
				System.out.println("Salary: " + rs.getDouble("salary"));
				System.out.println("Address: " + rs.getString("address"));
			} else {
				System.out.println("No employee found with ID: " + id);
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println("Failed Load Employee Details For the given Id " + e);
		}

	}

	// Delete Employee
	public void deleteEmployee() {
	    Connection conn = connectDb();

	    try {
	        String getEmpQuery = "delete from employee_data where id = ?";
	        PreparedStatement ps = conn.prepareStatement(getEmpQuery);

	        System.out.println("Enter Employee id to Delete Employee Details: ");
	        int id = sc.nextInt();

	        ps.setInt(1, id);

	        int rowsAffected = ps.executeUpdate();

	        if (rowsAffected > 0) {
	            System.out.println("Employee with ID " + id + " deleted successfully.");
	        } else {
	            System.out.println("No employee found with ID " + id);
	        }

	        conn.close();

	    } catch (SQLException e) {
	        System.out.println("Failed to Delete Employee " + e);
	    }
	}

	// Get ALL Employee
	public void getAllEmployee() {
		Connection conn = connectDb();

		try {

			String getEmpQuery = "select * from employee_data";

			PreparedStatement ps = conn.prepareStatement(getEmpQuery);

			ResultSet rs = ps.executeQuery();

			System.out.println("Showing All Employee Details From the Company");
			while (rs.next()) {
				System.out.println(
						"------------------------------------------------------------------------------------------");
				System.out.println("Employee Details for id " + rs.getInt("id"));
				System.out.println("First Name: " + rs.getString("firstName"));
				System.out.println("Last Name: " + rs.getString("lastName"));
				System.out.println("Email: " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
				System.out.println("Gender: " + rs.getString("gender"));
				System.out.println("Department: " + rs.getString("department"));
				System.out.println("Salary: " + rs.getDouble("salary"));
				System.out.println("Address: " + rs.getString("address"));
			}

			conn.close();

		} catch (SQLException e) {
			System.out.println("Failed to Get Employees Data" + e);
		}

	}

}
