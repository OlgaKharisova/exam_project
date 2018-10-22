package ru.innopolis.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;

import static ru.innopolis.dao.connection.HibernateUtils.getSessionFactory;

public abstract class BaseDAO<T>  {

    protected List<T> getAll(Class<T> type) {
        SessionFactory sessionFactory = getSessionFactory();
        try(Session session = sessionFactory.openSession()) {
            return session.createQuery("from " + type.getName()).list();
        }
    }

    public void saveOrUpdate(T t){
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.saveOrUpdate(t);
        session.getTransaction().commit();
        session.close();
    }

    public Serializable save(T t) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        Serializable primaryKey = session.save(t);
        session.getTransaction().commit();
        session.close();
        return primaryKey;
    }

    protected T get(Class<T> type, Serializable id) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        T entity = session.get(type, id);
        session.getTransaction().commit();
        session.close();
        return entity;
    }

    public void update(T t) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.update(t);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(T t) {
        Session session = getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(t);
        session.getTransaction().commit();
        session.close();
    }

}
