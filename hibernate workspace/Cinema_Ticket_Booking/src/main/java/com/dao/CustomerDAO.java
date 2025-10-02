package com.dao;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.entity.Booking;
import com.entity.Customer;
import com.entity.Movie;
import com.entity.Showtime;

public class CustomerDAO {

	public void addCustomer(Customer c) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(c);

		tr.commit();
		ss.close();
		sf.close();
	}

	public Customer getCustomer(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Movie.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		Customer c = ss.get(Customer.class, id);

		ss.close();
		sf.close();
		return c;
	}
}
