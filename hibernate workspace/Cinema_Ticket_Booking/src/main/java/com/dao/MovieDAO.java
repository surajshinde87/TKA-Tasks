package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Booking;
import com.entity.Customer;
import com.entity.Movie;
import com.entity.Showtime;

public class MovieDAO {

	public void addMovie(Movie m) {

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Movie.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Customer.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(m);
		tr.commit();
		ss.close();

	}
	
	public List<Movie> getAllMovies(){
		
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		cfg.addAnnotatedClass(Movie.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Customer.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String query = "from Movie";
		
		Query<Movie> m = ss.createQuery(query, Movie.class);
		
		List<Movie> list = m.list();
		tr.commit();
		ss.close();
		return list;
		
	}
	
	public Movie getMovieById(int id) {
	    Configuration cfg = new Configuration();
	    cfg.configure("hibernate.cfg.xml");
	    cfg.addAnnotatedClass(Movie.class);
		cfg.addAnnotatedClass(Showtime.class);
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Customer.class);
	    SessionFactory sf = cfg.buildSessionFactory();
	    Session ss = sf.openSession();
	    Transaction tr = ss.beginTransaction();

	    Movie movie = ss.get(Movie.class, id); 

	    tr.commit();
	    ss.close();
	    return movie;
	}


}
