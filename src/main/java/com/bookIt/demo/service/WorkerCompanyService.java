package com.bookIt.demo.service;
import com.bookIt.demo.repository.WorkerCompanyRepository;
import com.bookIt.demo.entity.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerCompanyService {

    @Autowired
    private WorkerCompanyRepository workerCompanyRepo;

    public List<Worker> findWorkersByCompanyId(Integer companyId) {
        return workerCompanyRepo.findWorkersByCompanyId(companyId);
    }

    public Worker removeFromCompany(Integer companyId, Integer workerId) {
        return workerCompanyRepo.deleteByCompanyIdAndWorkerId(companyId, workerId);
    }
}
