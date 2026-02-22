package com.lcwd.user.service.UserService.impl;

import com.lcwd.user.service.UserService.entities.User;
import com.lcwd.user.service.UserService.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.UserService.repositories.UserRepository;
import com.lcwd.user.service.UserService.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {

        return userRepository.findAll();
    }

    @Override
    public User getUser(String userId) {
        return userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("user with given id is not found in the server:" + userId));
    }

    @Override
    public User updateUser(String userId, User user) {

        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
