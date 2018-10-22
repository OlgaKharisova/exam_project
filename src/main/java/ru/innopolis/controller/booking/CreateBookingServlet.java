package ru.innopolis.controller.booking;

import ru.innopolis.service.BookingService;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateBookingServlet extends HttpServlet {

    private BookingService bookingService;

    public CreateBookingServlet() {
        bookingService = new BookingService();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        Long tourId = Long.valueOf(req.getParameter("tourId"));
        Long clientId = Long.valueOf(req.getParameter("clientId"));
        bookingService.saveBooking(tourId, clientId);
        resp.sendRedirect("/");
    }
}
