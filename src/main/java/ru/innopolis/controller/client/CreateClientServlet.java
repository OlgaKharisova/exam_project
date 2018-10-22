package ru.innopolis.controller.client;

import ru.innopolis.entity.user.Client;
import ru.innopolis.entity.user.UserInfo;
import ru.innopolis.service.ClientService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateClientServlet extends HttpServlet {

    private ClientService clientService;

    public CreateClientServlet() {
        clientService = new ClientService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create-client.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String patronymic = req.getParameter("patronymic");
        String email = req.getParameter("email");
        UserInfo userInfo = new UserInfo(name, secondName, patronymic);
        Client client = new Client(userInfo);
        clientService.saveClient(client);
        resp.sendRedirect("/");
    }
}