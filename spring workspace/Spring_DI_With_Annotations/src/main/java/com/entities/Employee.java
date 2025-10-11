package com.entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Employee {
	
	@Value("1001")
	int emp_id;
	
	@Value("suraj")
	String name;
	
	@Value("8 CTC")
	String salary;
	
	@Value("22")
	int age;
	
	@Value("Research & Development")
	String department;
	
	@Autowired
	Project project;
	
	public Employee() {
	}

	public Employee(int emp_id, String name, String salary, int age, String department, Project project) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.salary = salary;
		this.age = age;
		this.department = department;
		this.project = project;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getname() {
		return name;
	}

	public void setname(String name) {
		this.name = name;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	@Override
	public String toString() {
		return "Employee [emp_id=" + emp_id + ", name=" + name + ", salary=" + salary + ", age=" + age
				+ ", department=" + department + ", project=" + project + "]";
	}
	
	

}
