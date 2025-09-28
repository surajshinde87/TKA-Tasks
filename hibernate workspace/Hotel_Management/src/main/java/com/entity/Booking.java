package com.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Booking {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private int bookingId;

	    @ManyToOne
	    @JoinColumn(name = "guest_id", nullable = false)
	    private Guest guest;

	    @ManyToOne
	    @JoinColumn(name = "room_id", nullable = false)
	    private Room room;

	    @Column(nullable = false)
	    private LocalDate checkIn;

	    @Column(nullable = false)
	    private LocalDate checkOut;
	    
	   public Booking() {
	}

	   public Booking(int bookingId, Guest guest, Room room, LocalDate checkIn, LocalDate checkOut) {
		super();
		this.bookingId = bookingId;
		this.guest = guest;
		this.room = room;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	   }

	   public int getBookingId() {
		   return bookingId;
	   }

	   public void setBookingId(int bookingId) {
		   this.bookingId = bookingId;
	   }

	   public Guest getGuest() {
		   return guest;
	   }

	   public void setGuest(Guest guest) {
		   this.guest = guest;
	   }

	   public Room getRoom() {
		   return room;
	   }

	   public void setRoom(Room room) {
		   this.room = room;
	   }

	   public LocalDate getCheckIn() {
		   return checkIn;
	   }

	   public void setCheckIn(LocalDate checkIn) {
		   this.checkIn = checkIn;
	   }

	   public LocalDate getCheckOut() {
		   return checkOut;
	   }

	   public void setCheckOut(LocalDate checkOut) {
		   this.checkOut = checkOut;
	   }

	   @Override
	   public String toString() {
		return "Booking [bookingId=" + bookingId + ", guest=" + guest + ", room=" + room + ", checkIn=" + checkIn
				+ ", checkOut=" + checkOut + "]";
	   }
	   
	   
	   
	   

}
