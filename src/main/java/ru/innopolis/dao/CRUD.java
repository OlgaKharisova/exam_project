package ru.innopolis.dao;

public interface CRUD<T> {

    boolean save(T t);
    T get(long id);
    boolean update(T t);
    boolean delete(long id);

}
