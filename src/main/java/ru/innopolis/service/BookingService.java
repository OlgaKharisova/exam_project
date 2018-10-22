package ru.innopolis.service;

import ru.innopolis.dao.BookingDao;
import ru.innopolis.entity.Booking;
import ru.innopolis.entity.Tour;
import ru.innopolis.entity.user.Client;

public class BookingService {

    private BookingDao bookingDao;

    public BookingService() {
        bookingDao = new BookingDao();
    }

    public Long saveBooking(long clientId, long tourId) {
        Booking booking = new Booking();
        booking.setClient(new Client().setId(clientId));
        booking.setTour(new Tour().setId(tourId));
        booking.setTimestamp(System.currentTimeMillis() / 1000);
        return (Long) bookingDao.save(booking);
    }
}
