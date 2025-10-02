package com.dao;

import java.util.*;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Booking;
import com.entity.Customer;
import com.entity.Movie;
import com.entity.Showtime;

public class ShowtimeDAO {

	public void addShowtime(Showtime st) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Movie.class);
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(st);

		tr.commit();
		ss.close();
		sf.close();
	}

	public Showtime getShowtime(int id) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		Showtime st = ss.get(Showtime.class, id);

		ss.close();
		sf.close();
		return st;
	}

	public List<Showtime> getShowtimesByDate(Date date) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		Query<Showtime> q = ss.createQuery("from Showtime where date(showDate) = :d", Showtime.class);
		q.setParameter("d", date);
		List<Showtime> list = q.list();

		ss.close();
		sf.close();
		return list;
	}
}
