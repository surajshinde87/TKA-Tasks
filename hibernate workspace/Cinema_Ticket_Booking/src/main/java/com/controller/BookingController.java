package com.controller;

import com.entity.Booking;
import com.entity.Customer;
import com.entity.Showtime;
import com.service.BookingService;

import java.util.List;

public class BookingController {
    private BookingService bs = new BookingService();

    public void addBooking(Customer customer, Showtime showtime, int seats) {
        Booking b = new Booking();
        b.setCustomer(customer);
        b.setShowtime(showtime);
        b.setSeats(seats);
        bs.addBooking(b);
        System.out.println("Booking done for " + customer.getName() + " | Seats: " + seats);
    }

    public void getBookingsByMovie(int movieId) {
        List<Booking> list = bs.getBookingsByMovie(movieId);
        for (Booking b : list) {
            System.out.println("Booking ID: " + b.getId() + " | Customer: " + b.getCustomer().getName() + " | Seats: " + b.getSeats());
        }
    }

    public void getBookingsByShowtime(int showtimeId) {
        List<Booking> list = bs.getBookingsByShowtime(showtimeId);
        for (Booking b : list) {
            System.out.println("Booking ID: " + b.getId() + " | Customer: " + b.getCustomer().getName() + " | Seats: " + b.getSeats());
        }
    }
}
