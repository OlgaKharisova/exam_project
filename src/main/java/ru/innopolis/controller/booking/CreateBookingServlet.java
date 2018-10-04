package ru.innopolis.controller.booking;

import ru.innopolis.model.Booking;
import ru.innopolis.service.BookingService;
import ru.innopolis.service.BookingServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateBookingServlet extends HttpServlet {

    private BookingService bookingService;

    public CreateBookingServlet() {
        bookingService = new BookingServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Long tourId = Long.valueOf(req.getParameter("tourId"));
        Long clientID = Long.valueOf(req.getParameter("clientId"));
        Booking booking = new Booking(System.currentTimeMillis(), clientID, tourId);
        bookingService.saveBooking(booking);
        resp.sendRedirect("/");
    }
}
