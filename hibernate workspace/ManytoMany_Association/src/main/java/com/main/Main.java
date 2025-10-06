package com.main;

import java.util.ArrayList;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;
import com.entity.Project;

public class Main {
	
	public static void main(String[] args){
		
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Employee.class);
		cfg.addAnnotatedClass(Project.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		Employee e1 = new Employee();
		
		e1.setEmp_id(1);
		e1.setName("suraj");
		
		Employee e2 = new Employee();
		
		e2.setEmp_id(2);
		e2.setName("mahesh");
		
		Project p1 = new Project();
		p1.setP_id(1);
		p1.setProjectName("Ecommerce");
		
		Project p2 = new Project();
		p2.setP_id(2);
		p2.setProjectName("Finance");
		
		ArrayList<Employee> empList = new ArrayList<>();
		ArrayList<Project> pList = new ArrayList<>();
		
		empList.add(e1);
		empList.add(e2);
		
		
		pList.add(p1);
		pList.add(p2);
		
		e1.setProjects(pList);
		e2.setProjects(pList);
		
		// optional because i am using cascade all 
//		p1.setEmployees(empList);
//		p2.setEmployees(empList);
		
		ss.persist(e1);
		ss.persist(e2);
		
	 // will save automatic beacuse of cascase
//		ss.persist(p1);       
//		ss.persist(p2);
		
		tr.commit();
		ss.close();
		

		
		
	}

}
