package com.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Project {
	
	@Id
	private int p_id;
	
	private String projectName;
	
	@ManyToMany(mappedBy = "projects")
	private List<Employee> employees;
	
	public Project() {
		// TODO Auto-generated constructor stub
	}

	public Project(int p_id, String projectName, List<Employee> employees) {
		super();
		this.p_id = p_id;
		this.projectName = projectName;
		this.employees = employees;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	

}
