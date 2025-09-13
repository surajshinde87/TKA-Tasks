package com.controller;

import java.util.Scanner;

import com.service.EmployeeService;

public class EmployeeController {

	public static void main(String[] args) {

		EmployeeService emp = new EmployeeService();
		boolean start = true;

		while (start) {
			System.out.println(" ============== Welcome Employee Management System ===========");
			System.out.println("1. Add New Employee");
			System.out.println("2. Update Existing Employee");
			System.out.println("3. Get Single Employee");
			System.out.println("4. Delete an Employee");
			System.out.println("5. Get All Employee");
			System.out.println("6. Exit From The App");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter Operation No. You Want to Perform");

			int choice = sc.nextInt();
		
			switch (choice) {
			case 1:
				emp.insertData();
				break;
			case 2:
				emp.updateData();
				break;
			case 3:
				emp.getEmployee();
				break;
			case 4:
				emp.deleteEmployee();
				break;
			case 5:
				emp.getAllEmployee();
				break;
			case 6:
				start = false;
				System.out.println("Exitting the App");
				break;
			default:
				System.out.println("Invalid Choice");
				break;
			}
		}

		System.out.println("Application Stopped");
		
	}

}
