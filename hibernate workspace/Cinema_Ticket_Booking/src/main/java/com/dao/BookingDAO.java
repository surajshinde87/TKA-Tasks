package com.dao;

import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import com.entity.Booking;
import com.entity.Customer;
import com.entity.Movie;
import com.entity.Showtime;

public class BookingDAO {

	public void addBooking(Booking b) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(b);

		tr.commit();
		ss.close();
		sf.close();
	}

	public List<Booking> getBookingsByMovie(int movieId) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		Query<Booking> q = ss.createQuery("from Booking b where b.showtime.movie.id = :mid", Booking.class);
		q.setParameter("mid", movieId);
		List<Booking> list = q.list();

		ss.close();
		sf.close();
		return list;
	}

	public List<Booking> getBookingsByShowtime(int showtimeId) {
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Customer.class);
		cfg.addAnnotatedClass(Movie.class);
		
		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		Query<Booking> q = ss.createQuery("from Booking b where b.showtime.id = :sid", Booking.class);
		q.setParameter("sid", showtimeId);
		List<Booking> list = q.list();

		ss.close();
		sf.close();
		return list;
	}
}
