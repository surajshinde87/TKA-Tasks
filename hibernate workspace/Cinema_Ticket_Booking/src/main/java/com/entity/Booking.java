package com.entity;


import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int seats;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Showtime showtime;
    
    public Booking() {
    	
	}

	public Booking(int id, int seats, Customer customer, Showtime showtime) {
		super();
		this.id = id;
		this.seats = seats;
		this.customer = customer;
		this.showtime = showtime;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	@Override
	public String toString() {
		return "Booking [id=" + id + ", seats=" + seats + ", customer=" + customer + ", showtime=" + showtime + "]";
	}
    
    
    
    
    
}