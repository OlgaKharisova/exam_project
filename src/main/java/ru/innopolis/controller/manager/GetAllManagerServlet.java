package ru.innopolis.controller.manager;

import ru.innopolis.entity.user.Manager;
import ru.innopolis.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllManagerServlet extends HttpServlet {

    private ManagerService managerService;

    public GetAllManagerServlet() {
        managerService = new ManagerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Manager> managerList = managerService.getAll();
    }
}