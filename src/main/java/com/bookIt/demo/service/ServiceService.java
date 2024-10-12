package com.bookIt.demo.service;

import com.bookIt.demo.entity.Service;
import com.bookIt.demo.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceService {

    @Autowired
    private ServiceRepository serviceRepo;

    public Service save(Service service) {
       return serviceRepo.save(service);
    }
}
