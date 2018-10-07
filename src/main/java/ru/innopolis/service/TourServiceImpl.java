package ru.innopolis.service;

import ru.innopolis.dao.TourDao;
import ru.innopolis.model.Tour;

import java.util.List;

public class TourServiceImpl implements TourService {

    private TourDao tourDao;

    public TourServiceImpl() {
        tourDao = new TourDao();
    }

    @Override
    public boolean saveTour(Tour tour) {
        return tourDao.save(tour);
    }

    @Override
    public List<Tour> getAll() {
        return tourDao.getAll();
    }
}
