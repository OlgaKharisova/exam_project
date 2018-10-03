package ru.innopolis.service;

import ru.innopolis.model.Client;

import java.util.List;

public interface ClientService {

    boolean saveClient(Client client);

    List<Client> getAll();
}
