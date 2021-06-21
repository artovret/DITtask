package com.example.task4.service;

import com.example.task4.model.User;

import java.util.List;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByUsername(String username);

    User findById(Long id);

    User changeStatus(String username, String status);

    User passwordUpdate(User user);

    User roleUpdate(User user, List<String> roles);

    void delete(Long id);
}
