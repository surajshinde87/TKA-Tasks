package com.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.entity.Room;


public class RoomDAO {
	public void addRoom() {

		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

		Room r = new Room();

		r.setRoomNo(102);
		r.setRoomType("Double");
		r.setPricePerNight(1500.0f);
		r.setAvailable(true);
		

		ss.persist(r);

		System.out.println("Room Added Successfully");
		
		tr.commit();
		ss.close();

	}
	
	public void getRoomById() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();

	    int id = 2;
	    
	   Room room = ss.get(Room.class, id);
	   
	   System.out.println(room);
	   
	   tr.commit();
	   ss.close();
		
	}
	
	public void getAvailableRooms() {
		Configuration cfg = new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Room.class);

		SessionFactory sf = cfg.buildSessionFactory();
		Session ss = sf.openSession();
		Transaction tr = ss.beginTransaction();
		
		String hql = "FROM Room WHERE available = true";
	    List<Room> rooms = ss.createQuery(hql, Room.class).getResultList();
	    
	    for (Room r : rooms) {
	       System.out.println(r);
	        System.out.println("-----------------------");
	    }
	
	}
	
}
