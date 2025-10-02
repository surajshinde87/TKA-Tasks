package com.service;

import com.dao.ShowtimeDAO;
import com.entity.Showtime;
import java.util.*;

public class ShowtimeService {
    private ShowtimeDAO sd= new ShowtimeDAO();

    public void addShowtime(Showtime st) {
        sd.addShowtime(st);
    }

    public Showtime getShowtime(int id) {
        return sd.getShowtime(id);
    }

    public List<Showtime> getShowtimesByDate(Date d) {
        return sd.getShowtimesByDate(d);
    }
}
