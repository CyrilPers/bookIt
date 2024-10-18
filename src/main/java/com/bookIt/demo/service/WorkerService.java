package com.bookIt.demo.service;

import com.bookIt.demo.model.UserAccount;
import com.bookIt.demo.model.Worker;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.WorkerCompany;
import com.bookIt.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bookIt.demo.enums.code.customer.CustomerError.CUSTOMER_ALREADY_EXIST;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepo;

    @Autowired
    private UserAccountService userSvc;

    public Worker createWorker(Worker worker) throws FunctionalException {
        UserAccount userFromDb = userSvc.findByEmail(worker.getUser().getEmail());
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

    public Worker findByEmail(String email) {
        return workerRepo.findByEmail(email);
    }

    public List<Worker> findAll() {
        return workerRepo.findAll();
    }
}
