package com.bookIt.demo.service;

import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.*;
import com.bookIt.demo.repository.AppointementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointementService {

    @Autowired
    private CustomerService customerSvc;
    @Autowired
    private CompanyService companySvc;
    @Autowired
    private TreatmentService performanceSvc;
    @Autowired
    private AppointementRepository appointementRepo;

    public Appointement create(int companyId, int serviceId, int customerId) throws FunctionalException {
        Appointement appointement = new Appointement();
        Customer customer = customerSvc.findById(customerId);
        Company company = companySvc.findById(companyId);
        WorkerCompany workerCompany = company.getWorkerCompanies().get(0);
        Treatment treatment = performanceSvc.findById(serviceId);
        appointement.setCustomer(customer);
        appointement.setPerformance(treatment);
        appointement.setWorkerCompany(workerCompany);
        return appointementRepo.save(appointement);
    }

    public List<Appointement> findByCustomerId(int idCustomer) {
        return appointementRepo.findByCustomerId(idCustomer);
    }
}
