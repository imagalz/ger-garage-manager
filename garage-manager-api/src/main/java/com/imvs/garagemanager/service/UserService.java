package com.imvs.garagemanager.service;

import com.imvs.garagemanager.model.User;
import com.imvs.garagemanager.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@Component
public class UserService {

    private UserRepository repository;

    public User createUser(User user) {
        return repository.save(user);
     }

    public User updateUser(User user) {
        return repository.update(user);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public List<User> getUserByProfile(Long profileId) {
        return repository.findByProfileId(profileId);
    }

    public Optional<User> getUserById(Long id) {
        return repository.findById(id);
    }

    public Optional<User> getUserByEMail(String email) {
        return repository.findByEmail(email);
    }
}
