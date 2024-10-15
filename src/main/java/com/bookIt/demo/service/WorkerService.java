package com.bookIt.demo.service;

import com.bookIt.demo.entity.Customer;
import com.bookIt.demo.entity.User;
import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bookIt.demo.enums.code.customer.CustomerError.CUSTOMER_ALREADY_EXIST;
import static com.bookIt.demo.enums.code.worker.WorkerError.*;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepo;

    @Autowired
    private UserService userSvc;

    public Worker createWorker(Worker worker) throws FunctionalException {
        User userFromDb = userSvc.findByEmail(worker.getUser().getEmail());
        if (userFromDb.getCustomer() != null) throw new FunctionalException(CUSTOMER_ALREADY_EXIST);
        if (userFromDb != null) worker.getUser().setId(userFromDb.getId());
        return workerRepo.save(worker);
    }

    public Worker findById(int id) {
        return workerRepo.findById(id);
    }

    public Worker update(Worker worker) throws FunctionalException {
        return workerRepo.save(worker);
    }

    public Worker deleteById(int id) {
        return workerRepo.deleteById(id);
    }
}
