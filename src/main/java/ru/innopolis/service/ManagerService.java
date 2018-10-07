package ru.innopolis.service;

import ru.innopolis.model.Manager;

import java.util.List;

public interface ManagerService {

    boolean saveManager(Manager manager);

    List<Manager> getAll();

    Manager get(long id);
}
