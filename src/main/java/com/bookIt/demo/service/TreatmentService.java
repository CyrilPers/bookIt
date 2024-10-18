package com.bookIt.demo.service;

import com.bookIt.demo.model.Treatment;
import com.bookIt.demo.repository.TreatmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TreatmentService {

    @Autowired
    private TreatmentRepository treatmentRepo;

    public Treatment save(Treatment treatment) {
       return treatmentRepo.save(treatment);
    }

    public Treatment findById(int serviceId) {
        return treatmentRepo.findById(serviceId).get();
    }
}
