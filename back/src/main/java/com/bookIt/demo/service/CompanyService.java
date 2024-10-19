package com.bookIt.demo.service;

import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.Company;
import com.bookIt.demo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bookIt.demo.enums.code.company.CompanyError.COMPANY_NOT_FOUND;

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

    public Company update(Company company) throws FunctionalException {
        Company companyFromDb = companyRepo.findById(company.getId()).get();
        if (company == null) throw new FunctionalException(COMPANY_NOT_FOUND);
        companyFromDb.setName(company.getName());
        companyFromDb.setDescription(company.getDescription());
        return companyRepo.save(companyFromDb);
    }

}
