package ru.innopolis.service;

import ru.innopolis.dao.ManagerDao;
import ru.innopolis.entity.user.Manager;

import java.io.Serializable;
import java.util.List;

public class ManagerService {

    private ManagerDao managerDao;

    public ManagerService() {
        managerDao = new ManagerDao();
    }

    public Serializable saveManager(Manager manager) {
        return managerDao.save(manager);
    }

    public List<Manager> getAll() {
        return managerDao.getAll();
    }

    public Manager get(long id) {
        return managerDao.get(id);
    }
}
