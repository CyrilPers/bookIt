package com.bookIt.demo.restController;

import com.bookIt.demo.dto.AuthRequestDTO;
import com.bookIt.demo.dto.WorkerCompanyAuthRequestDTO;
import com.bookIt.demo.dto.WorkerCompanyAuthResponseDTO;
import com.bookIt.demo.model.Category;
import com.bookIt.demo.model.Company;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.model.Performance;
import com.bookIt.demo.service.AuthentificationWorkerService;
import com.bookIt.demo.service.CategoryService;
import com.bookIt.demo.service.CompanyService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping("/update/{id}")
    public Company update(@PathVariable int idCompany, @RequestBody Company company) {
        return companyService.update(idCompany, company);
    }

    @PostMapping("/login/{idCompany}")
    public WorkerCompanyAuthResponseDTO login(@PathVariable int idCompany, @RequestBody AuthRequestDTO authRequest) {
        return authWorkerSvc.login(authRequest, idCompany);
    }
}
