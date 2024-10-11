package com.bookIt.demo.service;

import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepo;

    public Worker createWorker(Worker worker) {
        return workerRepo.save(worker);
    }
}
