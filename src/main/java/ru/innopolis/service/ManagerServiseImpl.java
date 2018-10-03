package ru.innopolis.service;

import ru.innopolis.dao.ManagerDao;
import ru.innopolis.model.Manager;

public class ManagerServiseImpl implements ManagerService {

    ManagerDao managerDao;

    public ManagerServiseImpl() {
        managerDao = new ManagerDao();
    }

    @Override
    public boolean saveManager(Manager manager) {
        return managerDao.save(manager);
    }
}
