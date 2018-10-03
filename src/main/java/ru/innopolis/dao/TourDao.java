package ru.innopolis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.dao.connection.ConnectionManager;
import ru.innopolis.model.Manager;
import ru.innopolis.model.Tour;
import ru.innopolis.model.TourStatus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TourDao implements CRUD<Tour> {

    private final Logger logger = LogManager.getLogger(TourDao.class);
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();

    @Override
    public boolean save(Tour tour) {
        String query = "INSERT INTO tours values (DEFAULT, ?, ?, ?, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionManager.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setDouble(1, tour.getTourPrice());
            preparedStatement.setDouble(2, tour.getFlightPrice());
            preparedStatement.setDate(3, tour.getStartDate());
            preparedStatement.setDate(4, tour.getEndDate());
            preparedStatement.setInt(5, tour.getParticipantsCount());
            preparedStatement.setString(6, tour.getTourStatus().name());
            preparedStatement.setLong(7, tour.getCreator().getId());
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
                tour.setParticipantsCount(resultSet.getInt(6));
                tour.setTourStatus(TourStatus.valueOf(resultSet.getString(7)));
                long managerId = resultSet.getLong(8);
                ManagerDao managerDao = new ManagerDao();
                Manager manager = managerDao.get(managerId);
                tour.setCreator(manager);
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
                "participantscount = ?, tourstatus = ?, creator = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setDouble(1, tour.getTourPrice());
            preparedStatement.setDouble(2, tour.getFlightPrice());
            preparedStatement.setDate(3, tour.getStartDate());
            preparedStatement.setDate(4, tour.getEndDate());
            preparedStatement.setInt(5, tour.getParticipantsCount());
            preparedStatement.setString(6, tour.getTourStatus().name());
            preparedStatement.setLong(7, tour.getCreator().getId());
            preparedStatement.setLong(8, tour.getId());
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
}
