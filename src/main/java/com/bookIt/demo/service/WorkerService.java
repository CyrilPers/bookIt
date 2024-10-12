package com.bookIt.demo.service;

import com.bookIt.demo.entity.Customer;
import com.bookIt.demo.entity.User;
import com.bookIt.demo.entity.Worker;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.bookIt.demo.enums.code.worker.WorkerError.*;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepo;

    @Autowired
    private CustomerService customerSvc;

    public Worker createWorker(Worker worker) throws FunctionalException {
        Worker workerFromDb = workerRepo.findByEmail(worker.getEmail());
        if (workerFromDb != null) throw new FunctionalException(WORKER_ALREADY_EXIST);
        workerFromDb = findByPhoneNumber(worker);
        if (workerFromDb != null) throw new FunctionalException(PHONE_NUMBER_ALREADY_USED);
        Customer customerFromDb = customerSvc.findByEmail(worker.getEmail());
        if (customerFromDb != null) worker.setId(customerFromDb.getId());
        Worker workerSaved = workerRepo.findByEmail(worker.getEmail());
        if  (customerFromDb == null) {
            Customer customerToSave = new Customer(workerSaved);
            customerSvc.save(customerToSave);
        }
        return workerRepo.save(worker);
    }

    public Worker findById(int id) {
        return workerRepo.findById(id);
    }

    public Worker findByEmail(String email) {
        return workerRepo.findByEmail(email);
    }

    public Worker findByPhoneNumber(Worker worker) throws FunctionalException {
        return workerRepo.findByPhoneNumber(worker.getPhoneNumber());
    }

    public Worker update(Worker worker) throws FunctionalException {
        Worker workerFromDb = workerRepo.findById(worker.getId()).orElseThrow(() -> new FunctionalException(WORKER_NOT_FOUND));
        workerFromDb.setFirstName(worker.getFirstName());
        workerFromDb.setLastName(worker.getLastName());
        workerFromDb.setEmail(worker.getEmail());
        workerFromDb.setPhoneNumber(worker.getPhoneNumber());
        return workerRepo.save(workerFromDb);
    }

    public Worker deleteById(int id) {
        return workerRepo.deleteById(id);
    }
}
