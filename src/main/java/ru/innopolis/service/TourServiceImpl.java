package ru.innopolis.service;

import ru.innopolis.dao.TourDao;
import ru.innopolis.model.Tour;

public class TourServiceImpl implements TourService {

    TourDao tourDao;

    public TourServiceImpl() {
        tourDao = new TourDao();
    }

    @Override
    public boolean saveTour(Tour tour) {
        return tourDao.save(tour);
    }
}
