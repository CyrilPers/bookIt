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
    private TreatmentService performanceSvc;
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
        Treatment treatment = new Treatment();
        treatment.setName("Coupe");
        treatment.setDescription("Coupe de cheveux court");
        treatment.setPrice(BigDecimal.valueOf(25.5));
        treatment.setCompany(company);
        company.getTreatments().add(treatment);
        company.setAdminLink("1234");
        UserAccount userWorker = new UserAccount();
        userWorker.setEmail("worker@gmail.com");
        userWorker.setPassword(passwordEncoder.encode("password"));
        userWorker.setFirstName("Eddie");
        userWorker.setLastName("Doe");
        userWorker.setPhoneNumber("061234678");
        Worker worker = new Worker();
        worker.setUser(userWorker);
        WorkerCompany workerCompany = new WorkerCompany();
        workerCompany.setCompany(company);
        companySvc.save(company);
        customerSvc.save(customer);
        workerCompany.setWorker(worker);
        Role role = new Role();
        role.setName("ADMIN");
        workerCompany.getRoles().add(role);
        workerCompanySvc.save(workerCompany);
        Company company2 = new Company();
        company2.setName("BarberShop2");
        companySvc.save(company2);
    }
}
