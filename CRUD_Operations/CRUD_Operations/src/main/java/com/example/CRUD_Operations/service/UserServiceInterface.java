package com.example.CRUD_Operations.service;

import com.example.CRUD_Operations.model.User;

import java.util.List;

public interface UserServiceInterface {
    List<User> findAllUsers();
    User addNewUser(User user);
    User findById(long id);
    User updateUserEmail(long id,String email);
    String deleteUser(long id);
    List<User> addUsers(List<User>users);
    void updateUserEmails(List<User>users);
    List<User> getUsersByEmailDomain(String domain);
    int getUserCount();
    void addUserWithExceptionHandling(User user);
}
