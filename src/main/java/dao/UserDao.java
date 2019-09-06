package dao;

import pojo.User;
import java.util.List;

public interface UserDao {
    User getById(int id);
    User getByLogin(String login);
    List<User> getAll();
    void add(User user);
    void update(User user);
    void deleteById(int id);
}
