package com.bookIt.demo.restController;

import com.bookIt.demo.model.Performance;
import com.bookIt.demo.service.PerformanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private PerformanceService serviceSvc;

    @PostMapping("/createService")
    public Performance createService(Performance performance) {
        return serviceSvc.save(performance);
    }
}
