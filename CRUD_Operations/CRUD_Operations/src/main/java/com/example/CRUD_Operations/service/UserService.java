package com.example.CRUD_Operations.service;

import com.example.CRUD_Operations.model.User;
import com.example.CRUD_Operations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserServiceInterface{
    @Autowired
    private UserRepository userRepository;

    //Find all users
    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User addNewUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElse(null);
//        Optional<User> result = userRepository.findById(id);
//        if (result.isPresent()) {
//            return result.get();
//        } else {
//            return null;
//        }
    }

    @Override
    public User updateUserEmail(long id,String email) {
        userRepository.findById(id).orElse(null).setEmail(email);
        userRepository.save(userRepository.findById(id).orElse(null));
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public String deleteUser(long id) {
        try {
            userRepository.deleteById(id);
            return "Deleted";
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    @Override
    public void updateUserEmails(List<User> users) {
            for(User user:users)
            {
                userRepository.updateEmail(user.getId(),user.getEmail());
            }
    }

    @Override
    public List<User> getUsersByEmailDomain(String domain) {
        return userRepository.findUsersByEmailDomain(domain);
    }

    @Override
    public int getUserCount() {
        return userRepository.findCount();
    }

    @Override
    public void addUserWithExceptionHandling(User user) {
        Optional<User> user1 = userRepository.findById(user.getId());
        if(user1.isPresent())
            throw new DuplicateKeyException("Already exists");
        else
            userRepository.save(user);
    }
}
