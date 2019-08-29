package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public abstract class UserDaoFactory {
    public static UserDao getUserDAO() {
        Properties properties = new Properties();
        try(InputStream is = UserDaoFactory.class.getClassLoader().getResourceAsStream("config.properties")) {
            properties.load(is);
            String DAOtype = properties.getProperty("DAOtype");
            if (DAOtype.equals("hibernate")) {
                return new UserDaoHibernateImpl();
            } if (DAOtype.equals("jdbc")) {
                return new UserDaoJDBCImpl();
            } else {
                return null;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
