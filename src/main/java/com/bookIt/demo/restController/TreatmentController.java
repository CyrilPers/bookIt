package com.bookIt.demo.restController;

import com.bookIt.demo.model.Treatment;
import com.bookIt.demo.service.TreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
public class TreatmentController {

    @Autowired
    private TreatmentService treatmentSvc;

    @PostMapping("/createService")
    public Treatment createService(Treatment treatment) {
        return treatmentSvc.save(treatment);
    }
}
