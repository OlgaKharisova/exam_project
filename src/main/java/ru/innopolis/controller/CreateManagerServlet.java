package ru.innopolis.controller;

import ru.innopolis.model.Manager;
import ru.innopolis.service.ManagerServise;
import ru.innopolis.service.ManagerServiseImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateManagerServlet extends HttpServlet {

    private ManagerServise managerServise;

    public CreateManagerServlet() {
        managerServise = new ManagerServiseImpl();
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
        managerServise.saveManager(manager);
        resp.sendRedirect("/");
    }
}
