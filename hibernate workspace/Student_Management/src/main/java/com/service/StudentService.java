package com.service;

import com.dao.StudentDAO;

public class StudentService {
	
	StudentDAO sd = new StudentDAO();
	
	public void insertData() {
		sd.insertStudent();
	}
	
	public void updateData() {
		sd.updateStudent();
	}
	public void deleteData() {
		sd.deleteStudent();
	}
	public void getSingleData() {
		sd.getSingleStudent();
	}

}
