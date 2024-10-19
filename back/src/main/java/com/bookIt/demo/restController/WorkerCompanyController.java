package com.bookIt.demo.restController;

import com.bookIt.demo.model.WorkerCompany;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.service.WorkerCompanyService;
import com.bookIt.demo.model.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/workerCompany")
public class WorkerCompanyController {

    @Autowired
    private WorkerCompanyService workerCompanySvc;

    @Autowired
    private ModelMapper mapper;

    @GetMapping("/findWorkersByCompanyId/{companyId}")
    public List<Worker> getWorkersByCompanyId(@PathVariable int companyId) {
        return workerCompanySvc.findWorkersByCompanyId(companyId);
    }

    @DeleteMapping("/removeWorkerFromCompany")
    public Worker removeFromCompany(@RequestParam int companyId, @RequestParam int workerId) {
        return workerCompanySvc.removeFromCompany(companyId, workerId);
    }

    @PostMapping("/addWorkerToCompany")
    public Worker addWorkerToCompany(@RequestParam int companyId, @RequestParam int workerId) throws FunctionalException {
        return workerCompanySvc.addWorkerToCompany(companyId, workerId);
    }

    @GetMapping("/getWorkers")
    public List<Worker> getWorkersWithFreePlanningForService(@RequestParam int companyId, @RequestParam LocalDateTime date, @RequestParam int serviceId) {
        return workerCompanySvc.getWorkersWithFreePlanningForService(companyId, date, serviceId);
    }

    @PostMapping("/addRoleToWorker")
    public Worker addRoleToWorker(@RequestParam int companyId, @RequestParam int workerId, @RequestParam int roleId) throws FunctionalException {
        WorkerCompany workerCompany = workerCompanySvc.addRoleToWorker(companyId, workerId, roleId);
        return workerCompany.getWorker();
    }

}
