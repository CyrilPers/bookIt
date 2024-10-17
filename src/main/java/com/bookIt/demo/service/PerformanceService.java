package com.bookIt.demo.service;

import com.bookIt.demo.model.Performance;
import com.bookIt.demo.repository.PerformanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PerformanceService {

    @Autowired
    private PerformanceRepository performanceRepo;

    public Performance save(Performance performance) {
       return performanceRepo.save(performance);
    }

    public Performance findById(int serviceId) {
        return performanceRepo.findById(serviceId).get();
    }
}
