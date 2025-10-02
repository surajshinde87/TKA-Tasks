package com.entity;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Date showDate;
	private String time;
	
	@ManyToOne
	private Movie movie;
	
	@OneToMany(mappedBy = "showtime")
	private List<Booking> bookings = new ArrayList<>();
	
	public Showtime() {
	}

	public Showtime(int id, Date showDate, String time, Movie movie, List<Booking> bookings) {
		super();
		this.id = id;
		this.showDate = showDate;
		this.time = time;
		this.movie = movie;
		this.bookings = bookings;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getShowDate() {
		return showDate;
	}

	public void setShowDate(Date showDate) {
		this.showDate = showDate;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public List<Booking> getBookings() {
		return bookings;
	}

	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}

	@Override
	public String toString() {
		return "ShowTime [id=" + id + ", showDate=" + showDate + ", time=" + time + ", movie=" + movie + ", bookings="
				+ bookings + "]";
	}
	
	
}
