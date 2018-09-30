package ru.innopolis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.model.Manager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ManagerDao implements CRUD<Manager> {
    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final Logger logger = LogManager.getLogger(ManagerDao.class);

    @Override
    public boolean save(Manager manager) {
        String query = "INSERT INTO managers values (DEFAULT, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)
        ) {
            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getSecondName());
            preparedStatement.setString(3, manager.getPatronymic());
            preparedStatement.setString(4, manager.getEmail());

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                manager.setId(resultSet.getLong(1));
            }
            resultSet.close();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Manager get(long id) {
        Manager manager = null;
        String query = "SELECT * FROM managers WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                manager = new Manager();
                manager.setId(resultSet.getLong(1));
                manager.setName(resultSet.getString(2));
                manager.setSecondName(resultSet.getString(3));
                manager.setPatronymic(resultSet.getString(4));
                manager.setEmail(resultSet.getString(5));
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return manager;
    }

    @Override
    public boolean update(Manager manager) {
        String query = "UPDATE managers " +
                "SET name = ?, secondname = ?, patronymic = ?, email = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, manager.getName());
            preparedStatement.setString(2, manager.getSecondName());
            preparedStatement.setString(3, manager.getPatronymic());
            preparedStatement.setString(4, manager.getEmail());
            preparedStatement.setLong(5, manager.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM managers WHERE id=?";
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