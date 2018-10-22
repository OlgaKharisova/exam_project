package ru.innopolis.service;

import ru.innopolis.dao.TourDao;
import ru.innopolis.entity.Tour;

import java.io.Serializable;
import java.util.List;

public class TourService {

    private TourDao tourDao;

    public TourService() {
        tourDao = new TourDao();
    }

    public Serializable save(Tour tour) {
        return tourDao.save(tour);
    }

    public List<Tour> getAll() {
        return tourDao.getAll();
    }
}
