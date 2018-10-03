package ru.innopolis.controller.client;

import ru.innopolis.model.Client;
import ru.innopolis.service.ClientService;
import ru.innopolis.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateClientServlet extends HttpServlet {

    private ClientService clientService;

    public CreateClientServlet() {
        clientService = new ClientServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("create-client.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String secondName = req.getParameter("secondName");
        String patronymic = req.getParameter("patronymic");
        String email = req.getParameter("email");
        Client client = new Client(name, secondName, patronymic, email);
        clientService.saveClient(client);
        resp.sendRedirect("/");
    }
}
