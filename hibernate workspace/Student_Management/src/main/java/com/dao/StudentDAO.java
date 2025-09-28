package com.dao;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Student;

public class StudentDAO {

	Scanner sc = new Scanner(System.in);
	

	public void insertStudent() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();
            
			Student s = new Student();
			
			System.out.println("Enter Student Name :");
			String name = sc.nextLine();
			System.out.println("Enter Student Email :");
			String email = sc.nextLine();
			System.out.println("Enter Student Age :");
			int age = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student Contact NO :");
			Long phone = sc.nextLong();
			sc.nextLine();
			System.out.println("Enter Student City:");
			String city = sc.nextLine();
			
			
			
			
			s.setName(name);
			s.setEmail(email);
			s.setAge(age);
			s.setPhone(phone);
			s.setCity(city);

			ss.persist(s);

			System.out.println("Student Data is Inserted Successfully");

			tr.commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("Failed to Insert Student : " + e.getMessage());
		}

	}

	public void updateStudent() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			System.out.println("Enter Student ID To Update :");
			int id = sc.nextInt();
			
			Student s = ss.get(Student.class, id);
			
		
			if (s != null) {
			 
				System.out.println("Enter Student New Contact NO :");
				Long phone = sc.nextLong();
				sc.nextLine();
				System.out.println("Enter Student New City:");
				String city = sc.nextLine();
				
				s.setPhone(phone);
				s.setCity(city);
				
				ss.merge(s);
				
				ss.merge(s);
				System.out.println("Student Data is Updated Successfully");
			}else {
				System.out.println("Student Not Found with ID : " + id);
			}

			tr.commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("Failed to Insert Student : " + e.getMessage());
		}

	}
	
	public void deleteStudent() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			System.out.println("Enter Student ID To Delete :");
			int id = sc.nextInt();
			
			
			Student s = ss.get(Student.class, id);
		
			if (s != null) {
			
				ss.remove(s);
				System.out.println("Student Data is Deleted Successfully");
			}else {
				System.out.println("Student Not Found with ID : " + id);
			}

			tr.commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("Failed to Insert Student : " + e.getMessage());
		}

	}
	
	public void getSingleStudent() {

		try {
			Configuration cfg = new Configuration();
			cfg.configure("hibernate.cfg.xml");
			cfg.addAnnotatedClass(Student.class);

			SessionFactory sf = cfg.buildSessionFactory();
			Session ss = sf.openSession();
			Transaction tr = ss.beginTransaction();

			System.out.println("Enter Student ID To Get Student :");
			int id = sc.nextInt();
			
			
			Student s = ss.get(Student.class, id);
		
			if (s != null) {     
				System.out.println(s);
			}else { 
				System.out.println("Student Not Found with ID : " + id);
			}

			tr.commit();
			ss.close();
		} catch (Exception e) {
			System.out.println("Failed to Insert Student : " + e.getMessage());
		}

	}
	
}
