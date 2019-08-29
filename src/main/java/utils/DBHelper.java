package utils;

import org.hibernate.cfg.Configuration;
import pojo.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBHelper {
    private DBHelper() {
    }

    private static DBHelper instance;

    public static DBHelper getInstance() {
        if(instance==null) {
            instance = new DBHelper();
        }
        return instance;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/users",
                    "postgres",
                    "sa");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
    public Configuration getConfiguration() {
        Configuration configuration = new Configuration().configure();
        configuration.addAnnotatedClass(User.class);
        return configuration;
    }
}
