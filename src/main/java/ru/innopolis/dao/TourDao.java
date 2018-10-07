package ru.innopolis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.dao.connection.ConnectionManager;
import ru.innopolis.model.Manager;
import ru.innopolis.model.Tour;
import ru.innopolis.model.TourStatus;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TourDao implements DAO<Tour> {

    private final Logger logger = LogManager.getLogger(TourDao.class);
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    private ManagerDao managerDao = new ManagerDao();

    @Override
    public boolean save(Tour tour) {
        String query = "INSERT INTO tours values (DEFAULT, ?, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, tour.getTourPrice());
            preparedStatement.setDouble(2, tour.getFlightPrice());
            preparedStatement.setDate(3, tour.getStartDate());
            preparedStatement.setDate(4, tour.getEndDate());
            preparedStatement.setInt(5, tour.getMaxParticipants());
            preparedStatement.setString(6, tour.getTourStatus().name());
            preparedStatement.setLong(7, tour.getCreator().getId());
            preparedStatement.setString(8, tour.getDescription());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tour.setId(resultSet.getLong(1));
            }
            resultSet.close();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Tour get(long id) {
        Tour tour = null;
        String query = "SELECT * FROM tours WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                tour = new Tour();
                tour.setId(resultSet.getLong(1));
                tour.setTourPrice(resultSet.getDouble(2));
                tour.setFlightPrice(resultSet.getDouble(3));
                tour.setStartDate(resultSet.getDate(4));
                tour.setEndDate(resultSet.getDate(5));
                tour.setMaxParticipants(resultSet.getInt(6));
                tour.setTourStatus(TourStatus.valueOf(resultSet.getString(7)));
                long managerId = resultSet.getLong(8);
                ManagerDao managerDao = new ManagerDao();
                Manager manager = managerDao.get(managerId);
                tour.setCreator(manager);
                tour.setDescription(resultSet.getString(9));
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return tour;
    }

    @Override
    public boolean update(Tour tour) {
        String query = "UPDATE tours " +
                "SET tourprice = ?, flightprice = ?, startdate = ?, enddate = ?, " +
                "participantscount = ?, tourstatus = ?, creator = ?, description = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setDouble(1, tour.getTourPrice());
            preparedStatement.setDouble(2, tour.getFlightPrice());
            preparedStatement.setDate(3, tour.getStartDate());
            preparedStatement.setDate(4, tour.getEndDate());
            preparedStatement.setInt(5, tour.getMaxParticipants());
            preparedStatement.setString(6, tour.getTourStatus().name());
            preparedStatement.setLong(7, tour.getCreator().getId());
            preparedStatement.setLong(8, tour.getId());
            preparedStatement.setString(9, tour.getDescription());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM tours WHERE id=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public List<Tour> getAll() {
        String query = "SELECT * FROM tours";
        List<Tour> tours = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             Statement prepareStatement = connection.createStatement();
             ResultSet resultSet = prepareStatement.executeQuery(query))
        {
            while (resultSet.next()) {
                Tour tour = new Tour();
                tour.setId(resultSet.getLong(1));
                tour.setTourPrice(resultSet.getDouble(2));
                tour.setFlightPrice(resultSet.getDouble(3));
                tour.setStartDate(resultSet.getDate(4));
                tour.setEndDate(resultSet.getDate(5));
                tour.setMaxParticipants(resultSet.getInt(6));
                tour.setTourStatus(TourStatus.valueOf(resultSet.getString(7)));
                Manager manager = managerDao.get(resultSet.getLong(8));
                tour.setCreator(manager);
                tour.setDescription(resultSet.getString(9));
                tours.add(tour);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return tours;
    }
}
