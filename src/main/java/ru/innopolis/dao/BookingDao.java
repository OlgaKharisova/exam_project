package ru.innopolis.dao;

import ru.innopolis.entity.Booking;

import java.util.List;


public class BookingDao extends BaseDAO<Booking> {

    public List<Booking> getAll() {
        return super.getAll(Booking.class);
    }

    public Booking get(Long id) {
        return super.get(Booking.class, id);
    }

}