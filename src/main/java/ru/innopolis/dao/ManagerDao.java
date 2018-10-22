package ru.innopolis.dao;

import ru.innopolis.entity.user.Manager;

import java.util.List;

public class ManagerDao extends BaseDAO<Manager> {

    public List<Manager> getAll() {
        return super.getAll(Manager.class);
    }

    public Manager get(Long id) {
        return super.get(Manager.class, id);
    }

}