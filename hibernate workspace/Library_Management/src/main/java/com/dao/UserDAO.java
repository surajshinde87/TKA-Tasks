package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Book;
import com.entity.User;

public class UserDAO {

	public void addUser(User user) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.persist(user);
		System.out.println("User Added");

		tr.commit();
		ss.close();
	}

	public User getUserById(int userId) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();

		User user = ss.get(User.class, userId);
		ss.close();
		return user;
	}

	public void updateUser(User user) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		ss.merge(user);
		System.out.println("User Updated");

		tr.commit();
		ss.close();
	}

	// borrow means this book is taken for reading
	public void borrowBook(int userId, int bookId) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(User.class);
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		User user = ss.get(User.class, userId);
		Book book = ss.get(Book.class, bookId);

		if (user != null && book != null) {
			if (book.isAvailable()) {
				book.setAvailable(false);
				ss.merge(book);
				System.out.println(user.getName() + " borrowed " + book.getTitle());
			} else {
				System.out.println("Book not available");
			}
		} else {
			System.out.println("User or Book not found");
		}

		tr.commit();
		ss.close();
	}

	public void returnBook(int bookId) {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Book.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Book book = ss.get(Book.class, bookId);

		if (book != null) {
			book.setAvailable(true);
			ss.merge(book);
			System.out.println(book.getTitle() + " returned successfully");
		} else {
			System.out.println("Book not found");
		}

		tr.commit();
		ss.close();
	}
}