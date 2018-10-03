package ru.innopolis.dao;

/**
 * CRUD - create read update delete
 */
public interface CRUD<T> {

    boolean save(T t);
    T get(long id);
    boolean update(T t);
    boolean delete(long id);

}
