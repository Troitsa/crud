package service;

import dao.UserDao;
import dao.UserDaoFactory;
import pojo.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    private static UserServiceImpl instance;
    private UserServiceImpl() {
    }

    public static UserServiceImpl getInstance() {
        if (instance == null) {
            instance = new UserServiceImpl();
        }
        return instance;
    }

    private UserDao userDao = UserDaoFactory.getUserDAO();

    public void add(User user){
        userDao.add(user);
    }

    public List<User> getAll(){
        List<User> userList = userDao.getAll();
        return userList;
    }

    public void updateById(User user) {
        userDao.update(user);
    }

    public User getById(int id){
        return userDao.getById(id);
    }

    @Override
    public User getByLogin(String login, String password) {
        User user = userDao.getByLogin(login);
        if(user.getPassword().equals(password)) {
            return user;
        }
        else {
            return null;
        }
    }

    public void deleteById(int id){
        userDao.deleteById(id);
    }
}
