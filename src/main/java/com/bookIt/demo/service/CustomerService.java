package com.bookIt.demo.service;

import com.bookIt.demo.entity.Customer;
import com.bookIt.demo.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    public Customer save(Customer customer) {
        return customerRepo.save(customer);
    }

    public Customer findByEmail(String email) {
        return customerRepo.findByEmail(email);
    }
}
