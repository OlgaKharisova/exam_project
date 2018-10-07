package ru.innopolis.service;

import ru.innopolis.dao.ManagerDao;
import ru.innopolis.model.Manager;

import java.util.List;

public class ManagerServiceImpl implements ManagerService {

    private ManagerDao managerDao;

    public ManagerServiceImpl() {
        managerDao = new ManagerDao();
    }

    @Override
    public boolean saveManager(Manager manager) {
        return managerDao.save(manager);
    }

    @Override
    public List<Manager> getAll() {
        return managerDao.getAll();
    }
}
