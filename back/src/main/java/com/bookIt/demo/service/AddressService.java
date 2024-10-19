package com.bookIt.demo.service;

import com.bookIt.demo.model.Address;
import com.bookIt.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepo;

    public Address createAddress(Address address) {
        return addressRepo.save(address);
    }
}
