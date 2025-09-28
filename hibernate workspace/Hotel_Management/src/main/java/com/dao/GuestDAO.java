package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Guest;

public class GuestDAO {

	public void addGuest() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Guest.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Guest g = new Guest();

		g.setName("Suraj Shinde");
		g.setContactNo(8767027809l);
		g.setAadharNo(778877415542l);

		ss.persist(g);

		System.out.println("Guest Added Successfully");
		
		tr.commit();
		ss.close();

	}

	public void getGuestById() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Guest.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 1;

		Guest g = ss.get(Guest.class, id);

		if (g != null) {
			System.out.println(g);
		} else {
			System.out.println("Guest not found with id : " + id);
		}

		tr.commit();
		ss.close();

	}

}
