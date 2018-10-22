package ru.innopolis.service;

import ru.innopolis.dao.ClientDao;
import ru.innopolis.entity.user.Client;

import java.io.Serializable;
import java.util.List;

public class ClientService {

    private ClientDao clientDao;

    public ClientService() {
        clientDao = new ClientDao();
    }

    public Serializable saveClient(Client client) {
        return clientDao.save(client);
    }

    public List<Client> getAll() {
        return clientDao.getAll();
    }
}
