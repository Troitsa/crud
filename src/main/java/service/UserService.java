package service;

import dao.UserDAOImpl;
import dao.UserDao;
import pojo.User;
import java.util.List;

public class UserService {

    public UserDao userDao = new UserDAOImpl();

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

    public void deleteById(int id){
        userDao.deleteById(id);
    }
}
