package ru.innopolis.service;

import ru.innopolis.dao.ClientDao;
import ru.innopolis.model.Client;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    public ClientServiceImpl() {
        clientDao = new ClientDao();
    }

    public boolean saveClient(Client client) {
        return clientDao.save(client);
    }

    public List<Client> getAll() {
        return clientDao.getAll();
    }
}
