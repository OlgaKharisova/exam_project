package ru.innopolis.controller.client;

import ru.innopolis.model.Client;
import ru.innopolis.service.ClientService;
import ru.innopolis.service.ClientServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetAllClientServlet extends HttpServlet {
    private ClientService clientService;

    public GetAllClientServlet() {
        clientService = new ClientServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Client> clientList = clientService.getAll();
        req.setAttribute("clients", clientList);
        req.getRequestDispatcher("clients.jsp").forward(req, resp);
    }
}
