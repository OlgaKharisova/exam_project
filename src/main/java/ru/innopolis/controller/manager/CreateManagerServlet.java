package ru.innopolis.controller.manager;

import ru.innopolis.model.Manager;
import ru.innopolis.service.ManagerService;
import ru.innopolis.service.ManagerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateManagerServlet extends HttpServlet {

    private ManagerService managerService;

    public CreateManagerServlet() {
        managerService = new ManagerServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create-manager.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String patronymic = req.getParameter("patronymic");
        String email = req.getParameter("email");
        Manager manager = new Manager(name, secondName, patronymic, email);
        managerService.saveManager(manager);
        resp.sendRedirect("/");
    }
}
