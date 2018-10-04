package ru.innopolis.controller.manager;

import ru.innopolis.service.ManagerService;
import ru.innopolis.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAllManagerServlet extends HttpServlet {

    private ManagerService managerService;

    public GetAllManagerServlet() {
        managerService = new ManagerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Manager> managerList = managerService. //дописать
    }
}
