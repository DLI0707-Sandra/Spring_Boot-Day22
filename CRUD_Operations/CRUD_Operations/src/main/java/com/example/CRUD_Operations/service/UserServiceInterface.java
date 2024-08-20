package com.example.CRUD_Operations.service;

import com.example.CRUD_Operations.model.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAllUsers();
    User addNewUser(User user);
    User findById(long id);
    User updateUserEmail(long id,String email);
    String deleteUser(long id);
}
