package ru.innopolis.dao;

import java.util.List;

public interface DAO<T> extends CRUD<T> {

    List<T> getAll();
}
