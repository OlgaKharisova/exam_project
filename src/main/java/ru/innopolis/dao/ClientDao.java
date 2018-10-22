package ru.innopolis.dao;


import ru.innopolis.entity.user.Client;

import java.util.List;

public class ClientDao extends BaseDAO<Client> {


    public List<Client> getAll() {
        return super.getAll(Client.class);
    }

    public Client get(Long id) {
        return super.get(Client.class, id);
    }

}