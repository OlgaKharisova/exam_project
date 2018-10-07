package ru.innopolis.service;

import ru.innopolis.model.Tour;

import java.util.List;

public interface TourService {

    boolean saveTour(Tour tour);

    List<Tour> getAll();
}
