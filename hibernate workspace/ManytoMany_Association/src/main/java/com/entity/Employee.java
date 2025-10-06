package com.entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Employee {
	
	@Id
	private int emp_id;
	
	private String name;
	

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(
		        name = "employee_project",
		        joinColumns = @JoinColumn(name = "emp_id"),
		        inverseJoinColumns = @JoinColumn(name = "p_id")
		    )
   private	List<Project> projects;
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}

	public Employee(int emp_id, String name, List<Project> projects) {
		super();
		this.emp_id = emp_id;
		this.name = name;
		this.projects = projects;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	
	

}
