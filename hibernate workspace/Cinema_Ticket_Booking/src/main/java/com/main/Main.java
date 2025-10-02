package com.main;


import com.controller.*;
import com.entity.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
    	
        MovieController movieCtrl = new MovieController();
        CustomerController customerCtrl = new CustomerController();
        ShowtimeController showtimeCtrl = new ShowtimeController();
        BookingController bookingCtrl = new BookingController();

        //  Add a movie
//        movieCtrl.addMovie("Inception", "Sci-Fi");
//           movieCtrl.addMovie("Titanic", "Romance");
//        movieCtrl.addMovie("3 Idiots", "Comedy/Drama");
        
        // show all movie
//        movieCtrl.showAllMovies();
//          Movie movie =  movieCtrl.getMovieById(1);
//          System.out.println(movie);
           
//
//        // Add a customer
//        customerCtrl.addCustomer("Suraj");
//        customerCtrl.addCustomer("Aniket");
        
        Customer c = customerCtrl.getCustomer(1);
           System.out.println(c);
        
//
//        // Add showtime for a movie
//        Movie movie = movieCtrl.getMovieById(2);
        
//        showtimeCtrl.addShowtime(movie, new Date(), "07:30");
//
//        // Book tickets
//        Customer customer = customerCtrl.getCustomer(1); 
//        Showtime showtime = showtimeCtrl.getShowtime(2);  
//        bookingCtrl.addBooking(customer, showtime, 2);     // 2 is seats
//
//        // Fetch bookings by movie
//        bookingCtrl.getBookingsByMovie(1);   // booking id
//
//        //  Fetch bookings by showtime
//        bookingCtrl.getBookingsByShowtime(2);
    }
}
