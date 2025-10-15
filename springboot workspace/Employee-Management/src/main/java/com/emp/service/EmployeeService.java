package com.emp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.dao.EmployeeDao;
import com.emp.entities.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeDao dao;

	public String insertData(Employee emp) {
		String msg = dao.insertData(emp);
		return msg;
	}
	
	public String deleteData(int id) {
		String msg = dao.deleteData(id);
		return msg;
	}
	
	public String udateData(Employee emp, int id) {
		String msg = dao.updateData(emp, id);
		return msg;
	}

	public Employee getSingleData(int id) {
		Employee e1 = dao.getSingleData(id);
		return e1;
	}

	public List<Employee> getAllEmployees() {
		List<Employee> list = dao.getAllEmployees();
		return list;
	}
	
	

}
