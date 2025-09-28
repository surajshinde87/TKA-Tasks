package com.service;

import com.dao.BookingDAO;
import com.dao.GuestDAO;
import com.dao.RoomDAO;

public class HotelService {
	
	GuestDAO gd = new GuestDAO();
	RoomDAO rd = new RoomDAO();
	BookingDAO bd = new BookingDAO();
 	
	public void addNewGuest() {
		gd.addGuest();
	}
	
	public void getGuestById() {
		gd.getGuestById();
	}
	
	public void addRoom() {
		rd.addRoom();
	}
	public void getRoomById() {
		rd.getRoomById();
	}
	public void getAvalRooms() {
		rd.getAvailableRooms();
	}
	
	public void bookRoom() {
		bd.bookRoom();
	}
	
	public void getBookedRoomById() {
		bd.getBookedRoom();
	}
	public void removeBooking() {
		bd.removeBooking();
	}

}
