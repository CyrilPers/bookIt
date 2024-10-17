package com.bookIt.demo.service;

import com.bookIt.demo.model.Company;
import com.bookIt.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepo;

    @Autowired
    private CategoryService categorySvc;

    public Company findById(int idCompany) {
        return companyRepo.findById(idCompany);
    }

    public Company save(Company company) {
        return companyRepo.save(company);
    }

    public List<Company> findAll() {return companyRepo.findAll();}

    public Company update(int idCompany, Company company) {
        Company companyFromDb = companyRepo.findById(idCompany);
        companyFromDb.setName(company.getName());
        companyFromDb.setAddress(company.getAddress());
        companyFromDb.setServices(company.getServices());
        companyFromDb.setWorkerCompanies(company.getWorkerCompanies());
        companyFromDb.setCategories(company.getCategories());
        companyFromDb.setDescription(company.getDescription());
        return companyRepo.save(companyFromDb);
    }
}
