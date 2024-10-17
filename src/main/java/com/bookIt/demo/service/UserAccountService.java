package com.bookIt.demo.service;

import com.bookIt.demo.model.UserAccount;
import com.bookIt.demo.repository.UserAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserAccountService {

    @Autowired
    private UserAccountRepository userRepo;

    public UserAccount findByEmail(String email) {
        return userRepo.findByEmail(email);
    }

}
