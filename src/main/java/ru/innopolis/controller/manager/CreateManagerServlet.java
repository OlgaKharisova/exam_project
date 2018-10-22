package ru.innopolis.controller.manager;

import ru.innopolis.entity.user.Manager;
import ru.innopolis.entity.user.UserInfo;
import ru.innopolis.service.ManagerService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateManagerServlet extends HttpServlet {

    private ManagerService managerService;

    public CreateManagerServlet() {
        managerService = new ManagerService();
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
        UserInfo userInfo = new UserInfo(name, secondName, patronymic);
        Manager manager = new Manager(userInfo);
        managerService.saveManager(manager);
        resp.sendRedirect("/");
    }
}
