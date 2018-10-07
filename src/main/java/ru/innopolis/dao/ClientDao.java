package ru.innopolis.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import ru.innopolis.dao.connection.ConnectionManager;
import ru.innopolis.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao implements DAO<Client> {

    private static ConnectionManager connectionManager = ConnectionManager.getInstance();
    private final Logger logger = LogManager.getLogger(ClientDao.class);

    @Override
    public boolean save(Client client) {
        String query = "INSERT INTO clients values (DEFAULT, ?, ?, ?, ?) RETURNING id";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSecondName());
            preparedStatement.setString(3, client.getPatronymic());
            preparedStatement.setString(4, client.getEmail());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client.setId(resultSet.getLong(1));
            }
            resultSet.close();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Client get(long id) {
        Client client = null;
        String query = "SELECT * FROM clients WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                client = new Client();
                client.setId(resultSet.getLong(1));
                client.setName(resultSet.getString(2));
                client.setSecondName(resultSet.getString(3));
                client.setPatronymic(resultSet.getString(4));
                client.setEmail(resultSet.getString(5));
            }
            resultSet.close();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return client;
    }

    @Override
    public boolean update(Client client) {
        String query = "UPDATE clients " +
                "SET name = ?, secondname = ?, patronymic = ?, email = ? " +
                "WHERE id = ?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query))
        {
            preparedStatement.setString(1, client.getName());
            preparedStatement.setString(2, client.getSecondName());
            preparedStatement.setString(3, client.getPatronymic());
            preparedStatement.setString(4, client.getEmail());
            preparedStatement.setLong(5, client.getId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(long id) {
        String query = "DELETE FROM clients WHERE id=?";
        try (Connection connection = connectionManager.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
            return false;
        }
        return true;
    }

    @Override
    public List<Client> getAll() {
        String query = "SELECT * FROM clients";
        List<Client> clients = new ArrayList<>();
        try (Connection connection = connectionManager.getConnection();
             Statement preparedStatement = connection.createStatement();
             ResultSet resultSet = preparedStatement.executeQuery(query))
        {
            while (resultSet.next()) {
                Client client = new Client();
                client.setId(resultSet.getLong(1));
                client.setName(resultSet.getString(2));
                client.setSecondName(resultSet.getString(3));
                client.setPatronymic(resultSet.getString(4));
                client.setEmail(resultSet.getString(5));
                clients.add(client);
            }
        } catch (SQLException e) {
            logger.error(e.getMessage(), e);
        }
        return clients;
    }
}