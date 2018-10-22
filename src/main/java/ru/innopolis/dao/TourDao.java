package ru.innopolis.dao;

import ru.innopolis.entity.Tour;

import java.io.Serializable;
import java.util.List;

public class TourDao extends BaseDAO<Tour> {

    public List<Tour> getAll() {
        return super.getAll(Tour.class);
    }

    public Tour get(Long id) {
        return super.get(Tour.class, id);
    }
}