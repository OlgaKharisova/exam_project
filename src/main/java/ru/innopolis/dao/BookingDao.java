package ru.innopolis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.dao.connection.ConnectionManager;
import ru.innopolis.model.*;

import java.sql.*;

public class BookingDao implements CRUD<Booking> {

    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final Logger logger = LogManager.getLogger(BookingDao.class);

    @Override
    public boolean save(Booking booking) {
        String query = "INSERT INTO bookings values (DEFAULT, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setTimestamp(1, new Timestamp(booking.getTimestamp()));
            preparedStatement.setLong(2, booking.getClient().getId());
            preparedStatement.setLong(3, booking.getTour().getId());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) {
                booking.setId(resultSet.getLong(1));
            }
            resultSet.close();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Booking get(long id) {
        Booking booking = null;
        String query = "SELECT * FROM bookings WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                booking = new Booking();
                booking.setId(resultSet.getLong(1));
                booking.setTimestamp(resultSet.getTimestamp(2).getTime());
                long clientID = resultSet.getLong(3);
                ClientDao clientDao = new ClientDao();
                Client client = clientDao.get(clientID);
                booking.setClient(client);
                long tourID = resultSet.getLong(4);
                TourDao tourDao = new TourDao();
                Tour tour = tourDao.get(tourID);
                booking.setTour(tour);
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return booking;
    }

    @Override
    public boolean update(Booking booking) {
        String query = "UPDATE bookings " +
                "SET timestamp = ?, client = ?, tour = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setTimestamp(1, new Timestamp(booking.getTimestamp()));
            preparedStatement.setLong(2, booking.getClient().getId());
            preparedStatement.setLong(3, booking.getTour().getId());
            preparedStatement.setLong(4, booking.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM bookings WHERE id=?";
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
