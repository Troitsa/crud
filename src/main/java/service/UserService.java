package service;

import dao.UserDao;
import pojo.User;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public UserDao userDao = new UserDao();

    public void add(User user){
        try {
            userDao.add(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAll(){
        List<User> userList = new ArrayList<>();
        try {
            userList = userDao.getAll();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void updateById(User user) {
        try {
            userDao.update(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public User getById(int id){
        User user = null;
        try {
            user = userDao.getById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteById(int id){
        try {
            userDao.deleteById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
