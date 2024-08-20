package com.example.CRUD_Operations.controller;

import com.example.CRUD_Operations.model.User;
import com.example.CRUD_Operations.repository.UserRepository;
import com.example.CRUD_Operations.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/all")
    public List<User> getAllUsers()
    {
        return userService.findAllUsers();
    }

    @PostMapping("/users")
    public User createEmployee(@RequestBody User user) {
        return userService.addNewUser(user);
    }

    @GetMapping("/users/{id}")
    public User findUserByAdd(@PathVariable("id") long id)
    {
        return userService.findById(id);
    }

    @PatchMapping("/users/update")
    public User updateEmail(@RequestBody User user)
    {
        return userService.updateUserEmail(user.getId(),user.getEmail());
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") long id)
    {
        if(userService.deleteUser(id)!=null)
            return "Deleted!";
        else
            return "Could not delete!";
    }

    @PostMapping("/addmultiple")
    public List<User> addMultiple(@RequestBody List<User>users)
    {
        return userService.addUsers(users);
    }

    @PatchMapping("/update/emails")
    public void updateMultiple(@RequestBody List<User>users)
    {
        userService.updateUserEmails(users);
    }


}
