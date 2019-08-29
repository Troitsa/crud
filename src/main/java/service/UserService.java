package service;

import pojo.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getAll();
    void updateById(User user);
    User getById(int id);
    void deleteById(int id);
}
