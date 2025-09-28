package com.controller;

import com.service.StudentService;

public class StudentController {

	public static void main(String[] args) {

		StudentService stud = new StudentService();
		stud.insertData();
		stud.updateData();
		stud.deleteData();
		stud.getSingleData();
		

	}

}
