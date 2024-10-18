package com.bookIt.demo.restController;

import com.bookIt.demo.dto.AuthRequestDTO;
import com.bookIt.demo.dto.WorkerAuthResponseDTO;
import com.bookIt.demo.model.Category;
import com.bookIt.demo.model.Company;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.security.SecurityService;
import com.bookIt.demo.service.AuthentificationWorkerService;
import com.bookIt.demo.service.CategoryService;
import com.bookIt.demo.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @Autowired
    ModelMapper mapper;

    @Autowired
    CategoryService categorySvc;

    @Autowired
    private AuthentificationWorkerService authWorkerSvc;

    @Autowired
    private SecurityService securitySvc;

    @GetMapping("/findById/{idCompany}")
    public Company findById(@PathVariable int idCompany) {
        return companyService.findById(idCompany);
    }

    @PostMapping(value = "/create")
    public Company create(@RequestParam String name, @RequestParam String description, @RequestParam(required = false) List<Integer> categories) throws FunctionalException {
        Company company = new Company(name, description);
        List<Category> categoryList = new ArrayList<>();
        for (Integer categoryId: categories) {
            Category categoryFromDb = categorySvc.findById(categoryId);
            categoryList.add(categoryFromDb);
        }
        company.setCategories(categoryList);
        return companyService.save(company);
    }

    @GetMapping("/all")
    public List<Company> getAll() {
        return companyService.findAll();
    }

    @PostMapping("/update/")
    public Company update(@RequestParam Integer idCompany, @RequestBody Company company) {
        return companyService.update(idCompany, company);
    }

    @PostMapping("/{idCompany}/login")
    public WorkerAuthResponseDTO login(@RequestBody AuthRequestDTO authRequest) {
        return authWorkerSvc.login(authRequest);
    }


    @PostMapping("/{idCompany}/updateName/{newName}")
    @PreAuthorize("@customCompanySecurity.hasCompanyRole(authentication, #idCompany.toString(), 'ADMIN')")
    public Company updateName(@PathVariable Integer idCompany, @PathVariable String newName) {
        Company company = companyService.findById(idCompany);
        company.setName(newName);
        return companyService.update(idCompany, company);
    }
}
