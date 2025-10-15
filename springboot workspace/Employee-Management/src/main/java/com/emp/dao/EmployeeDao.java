package com.emp.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emp.entities.Employee;

@Repository
public class EmployeeDao {

	@Autowired
	SessionFactory factory;

	public String insertData(Employee emp) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.persist(emp);
		tx.commit();
		session.close();

		String msg = "Data is Inserted";

		return msg;

	}

	public String deleteData(int empId) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = session.get(Employee.class, empId);
		session.remove(e1);
		tx.commit();
		session.close();

		String msg = "Data is deleted with id : " + empId;
		return msg;
	}

	public String updateData(Employee emp, int empId) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		Employee e1 = session.get(Employee.class, empId);
		e1.setName(emp.getName());
		e1.setSalary(emp.getSalary());
		session.merge(e1);
		tx.commit();
		session.close();

		String msg = "Data is udated for the id : " + empId;
		return msg;
	}

	public Employee getSingleData(int empId) {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Employee emp = session.get(Employee.class, empId);

		tx.commit();
		session.close();

		return emp;
	}

	public List<Employee> getAllEmployees() {

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		List<Employee> list = session.createQuery("from Employee", Employee.class).list();

		tx.commit();
		session.close();

		return list;
	}

}
