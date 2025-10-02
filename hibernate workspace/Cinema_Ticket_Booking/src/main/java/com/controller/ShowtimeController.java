package com.controller;

import com.entity.Movie;
import com.entity.Showtime;
import com.service.ShowtimeService;
import java.util.*;

public class ShowtimeController {
    private ShowtimeService sts = new ShowtimeService();

    public void addShowtime(Movie movie, Date date, String time) {
        Showtime st = new Showtime();
        st.setMovie(movie);
        st.setShowDate(date);
        st.setTime(time);
        sts.addShowtime(st);
        System.out.println("Showtime scheduled for " + movie.getTitle() + " on " + date + " at " + time);
    }

    public void getShowtimesByDate(Date date) {
        List<Showtime> list = sts.getShowtimesByDate(date);
        for (Showtime st : list) {
            System.out.println("Showtime ID: " + st.getId() + " | Movie: " + st.getMovie().getTitle() + " | Time: " + st.getTime());
        }
    }

    public Showtime getShowtime(int id) {
        return sts.getShowtime(id);
    }
}
