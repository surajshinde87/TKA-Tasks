package com.dao;

import java.time.LocalDate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Booking;
import com.entity.Guest;
import com.entity.Room;

public class BookingDAO {

	public void bookRoom() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Guest.class);
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Booking b = new Booking();

		Guest g = ss.get(Guest.class, 2);
		Room r = ss.get(Room.class, 1);

		if (g != null && r != null) {
			 // Check if room is already booked
	        if (r.isAvailable()) {
	            b.setGuest(g);
	            b.setRoom(r);
	            b.setCheckIn(LocalDate.of(2025, 9, 28));
	            b.setCheckOut(LocalDate.of(2025, 9, 29));

	            r.setAvailable(false);
	            ss.merge(r);
	            ss.persist(b);

	            tr.commit();
	            ss.close();
	            System.out.println("Room booked successfully!");
	        } else {
	            System.out.println("Room is already booked! Please choose another room.");
	        }
		} else {
			System.out.println("Guest or Room not found!");
		}
	}

	public void getBookedRoom() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Guest.class);
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 1;
		Booking b = ss.get(Booking.class, id);
		if (b != null) {
			System.out.println(b);
			tr.commit();
			ss.close();
		} else {
			System.out.println("No booking found with : " + id);
		}

	}

	public void removeBooking() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Booking.class);
		cfg.addAnnotatedClass(Guest.class);
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		int id = 1;
		Booking b = ss.get(Booking.class, id);
		if (b != null) {
			Room room = b.getRoom();
	        room.setAvailable(true);
	        ss.merge(room);
			ss.remove(b);
			System.out.println("Room Booking Deleted or Cancelled");
			tr.commit();
			ss.close();
		} else {
			System.out.println("No booking found with : " + id);
		}

	}

}
