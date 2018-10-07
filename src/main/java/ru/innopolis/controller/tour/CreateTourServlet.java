package ru.innopolis.controller.tour;

import ru.innopolis.model.Manager;
import ru.innopolis.model.Tour;
import ru.innopolis.model.TourStatus;
import ru.innopolis.service.ManagerService;
import ru.innopolis.service.ManagerServiceImpl;
import ru.innopolis.service.TourService;
import ru.innopolis.service.TourServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

public class CreateTourServlet extends HttpServlet {

    private TourService tourService;
    private ManagerService managerService;

    public CreateTourServlet() {
        tourService = new TourServiceImpl();
        managerService = new ManagerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create-tour.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Tour tour = new Tour();
        tour.setTourPrice(Double.valueOf(req.getParameter("tourPrice")));
        tour.setFlightPrice(Double.valueOf(req.getParameter("flightPrice")));
        tour.setStartDate(Date.valueOf(req.getParameter("startDate")));
        tour.setEndDate(Date.valueOf(req.getParameter("endDate")));
        tour.setMaxParticipants(Integer.valueOf(req.getParameter("maxParticipants")));
        Manager manager = managerService.get(Integer.valueOf(req.getParameter("creator")));
        tour.setCreator(manager);
        tour.setTourStatus(TourStatus.valueOf(req.getParameter("tourStatus")));
        tour.setDescription(req.getParameter("description"));
        tourService.saveTour(tour);
        resp.sendRedirect("/");
    }
}
