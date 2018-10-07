package ru.innopolis.controller;

import ru.innopolis.model.Tour;
import ru.innopolis.service.TourService;
import ru.innopolis.service.TourServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Сервлет главной(корневой) страницы
 */
public class MainPageServlet extends HttpServlet {

    private TourService tourService;

    public MainPageServlet() {
        this.tourService = new TourServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tour> tours = tourService.getAll();
        req.setAttribute("tours", tours);
        req.getRequestDispatcher("main-page.jsp").forward(req,resp);
    }
}
