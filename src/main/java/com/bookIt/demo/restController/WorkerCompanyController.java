package com.bookIt.demo.restController;

import com.bookIt.demo.service.WorkerCompanyService;
import com.bookIt.demo.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workerCompany")
public class WorkerCompanyController {

    @Autowired
    private WorkerCompanyService workerCompanySvc;

    @GetMapping("/findWorkersByCompanyId/{companyId}")
    public List<Worker> findWorkersByCompanyId(@PathVariable int companyId) {
        return workerCompanySvc.findWorkersByCompanyId(companyId);
    }

    @GetMapping("/removeWorkerFromCompany")
    public Worker removeFromCompany(@RequestParam int companyId, @RequestParam int workerId) {
        return workerCompanySvc.removeFromCompany(companyId, workerId);
    }


}
