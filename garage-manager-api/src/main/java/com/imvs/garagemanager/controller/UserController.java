package com.imvs.garagemanager.controller;

import com.imvs.garagemanager.controller.request.LoginRequest;
import com.imvs.garagemanager.model.User;
import com.imvs.garagemanager.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Component
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<User> login(@RequestBody LoginRequest loginInfo) {
        Optional<User> response = service.getUserByEMail(loginInfo.getUsername());

        HttpStatus httpStatus = HttpStatus.OK;

        if (!response.get().getPassword().equals(loginInfo.getPassword())){
            httpStatus = HttpStatus.NOT_ACCEPTABLE;
        }

        return new ResponseEntity<>(response.get(), httpStatus);
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User response = service.createUser(user);

        return new ResponseEntity<User>(response, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User response = service.updateUser(user);

        return new ResponseEntity<User>(response, HttpStatus.OK);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") Long userId) {
        Optional<User> response = service.getUserById(userId);

        return new ResponseEntity<User>(response.get(), HttpStatus.OK);
    }

    @GetMapping("/profile/{profileId}")
    public ResponseEntity<List<User>> getUserByProfile(@PathVariable("profileId") Long profileId) {
        List<User> response =service.getUserByProfile(profileId);

        return new ResponseEntity<List<User>>(response, HttpStatus.OK);
    }

    @GetMapping("/")
    private ResponseEntity<List<User>> getAllUsers() {
        List<User> response = service.getUsers();

        return new ResponseEntity<List<User>>(response, HttpStatus.OK);
    }
    
}
