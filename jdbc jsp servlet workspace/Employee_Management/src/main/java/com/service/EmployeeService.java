package com.service;

import com.dao.EmployeeDao;

public class EmployeeService {

	EmployeeDao dao = new EmployeeDao();

	public void insertData() {
		dao.addEmployee();
	}

	public void updateData() {
		dao.updateEmployee();
	}

	public void getEmployee() {
		dao.getEmployee();
	}

	public void deleteEmployee() {
		dao.deleteEmployee();
	}

	public void getAllEmployee() {
		dao.getAllEmployee();
	}

}
