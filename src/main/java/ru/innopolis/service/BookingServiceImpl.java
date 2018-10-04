package ru.innopolis.service;

import ru.innopolis.dao.BookingDao;
import ru.innopolis.model.Booking;

public class BookingServiceImpl implements BookingService {

    private BookingDao bookingDao;

    public BookingServiceImpl() {
        bookingDao = new BookingDao();
    }

    @Override
    public boolean saveBooking(Booking booking) {
        return bookingDao.save(booking);
    }
}
