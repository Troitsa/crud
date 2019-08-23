package dao;

import pojo.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {

    public User getById(int id) throws SQLException {
        ResultSet resultSet;
        User user = null;
        try (Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE id= ?");
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
        }
        if (resultSet.next()) {
            user = new User(
                    resultSet.getInt("id")
                    , resultSet.getString("name")
                    , resultSet.getString("login")
                    , resultSet.getString("password"));
        }
        return user;
    }

    public List<User> getAll() throws SQLException {
        ArrayList<User> result = new ArrayList<>();

        ResultSet resultSet;
        try (Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users ORDER BY id ASC");
            resultSet = preparedStatement.executeQuery();
        }
        while (resultSet.next()) {
            User user = new User(
                    resultSet.getInt("id")
                    , resultSet.getString("name")
                    , resultSet.getString("login")
                    , resultSet.getString("password"));
            result.add(user);
        }
        return result;
    }

    public void add(User user) throws SQLException {
        String sql = "INSERT INTO users (name,login,password) VALUES (?,?,?)";
        try (Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.executeUpdate();
        }
    }

    public void update(User user) throws SQLException {
        String sql = "UPDATE users SET name = ?, login = ?, password  = ? WHERE id = ?";
        try (Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user.getName());
            statement.setString(2, user.getLogin());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        }
    }

    public void deleteById(int id) throws SQLException{
        String sql = "DELETE FROM users WHERE id=?";
        try (Connection connection = new ConnectionManager().getConnection()) {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
        }
    }
}
