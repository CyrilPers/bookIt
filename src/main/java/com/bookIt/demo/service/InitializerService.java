package com.bookIt.demo.service;

import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class InitializerService {

    @Autowired
    private CompanyService companySvc;
    @Autowired
    private CustomerService customerSvc;
    @Autowired
    private PerformanceService performanceSvc;
    @Autowired
    private WorkerCompanyService workerCompanySvc;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostConstruct
    public void init() throws FunctionalException {
        Company company = new Company();
        company.setName("BarberShop");
        UserAccount userCustomer = new UserAccount();
        userCustomer.setEmail("customer@gmail.com");
        userCustomer.setPassword(passwordEncoder.encode("password"));
        userCustomer.setFirstName("John");
        userCustomer.setLastName("Smith");
        userCustomer.setPhoneNumber("0612345678");
        Customer customer = new Customer();
        customer.setUser(userCustomer);
        customer.setAdvertising(false);
        Performance performance = new Performance();
        performance.setName("Coupe");
        performance.setDescription("Coupe de cheveux court");
        performance.setPrice(BigDecimal.valueOf(25.5));
        performance.setCompany(company);
        company.getPerformances().add(performance);
        UserAccount userWorker = new UserAccount();
        userWorker.setEmail("worker@gmail.com");
        userWorker.setPassword(passwordEncoder.encode("password"));
        userWorker.setFirstName("Eddie");
        userWorker.setLastName("Doe");
        userWorker.setPhoneNumber("0612345678");
        Worker worker = new Worker();
        worker.setUser(userWorker);
        WorkerCompany workerCompany = new WorkerCompany();
        workerCompany.setCompany(company);
        companySvc.save(company);
        customerSvc.save(customer);
        workerCompanySvc.save(workerCompany);
    }
}
