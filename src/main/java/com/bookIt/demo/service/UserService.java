package com.bookIt.demo.service;

import com.bookIt.demo.entity.User;
import com.bookIt.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public User findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
