package com.bookIt.demo.restController;

import com.bookIt.demo.entity.Service;
import com.bookIt.demo.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/service")
public class ServiceController {

    @Autowired
    private ServiceService serviceSvc;

    @PostMapping("/createService")
    public Service createService(Service service) {
        return serviceSvc.save(service);
    }
}
