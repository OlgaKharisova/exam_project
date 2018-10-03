package ru.innopolis.controller.manager;

import ru.innopolis.model.Manager;
import ru.innopolis.service.ManagerService;
import ru.innopolis.service.ManagerServiseImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllManagerServlet extends HttpServlet {

    private ManagerService managerService;

    public GetAllManagerServlet() {
        managerService = new ManagerServiseImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        List<Manager> managerList = managerService. //дописать
    }
}
