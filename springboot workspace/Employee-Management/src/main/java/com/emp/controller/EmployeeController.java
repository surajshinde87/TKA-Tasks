package com.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.emp.entities.Employee;
import com.emp.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	 EmployeeService service;
	
	@PostMapping("/add")
	public String insertData(@RequestBody Employee emp) {
		String msg = service.insertData(emp);
		return msg;
	}
	
	@GetMapping("/getsingle/{empId}")
	public Employee getSingleData(@PathVariable int empId) {
		Employee e = service.getSingleData(empId);
		return e;
	}
	
	@GetMapping("/getall")
	public List<Employee> getAllEmployees() {
		
		List<Employee> empList = service.getAllEmployees();
		return empList;
		
	}
	
	@PutMapping("/update/{empId}")
	public String updateData(@RequestBody Employee emp, int empId) {
		
		String msg = service.udateData(emp, empId);
		return msg;
	}
	
	@DeleteMapping("/delete/{empId}")
	public String deleteData(@PathVariable int empId) {
		String msg = service.deleteData(empId);
		return msg;
	}
	
	
	
	
}
