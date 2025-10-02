package com.service;

import com.dao.BookingDAO;
import com.entity.Booking;
import java.util.List;

public class BookingService {
    private BookingDAO bd = new BookingDAO();

    public void addBooking(Booking b) {
        bd.addBooking(b);
    }

    public List<Booking> getBookingsByMovie(int movieId) {
        return bd.getBookingsByMovie(movieId);
    }

    public List<Booking> getBookingsByShowtime(int showtimeId) {
        return bd.getBookingsByShowtime(showtimeId);
    }
}
