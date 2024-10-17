package com.bookIt.demo.controler;

import com.bookIt.demo.model.Category;
import com.bookIt.demo.model.Company;
import com.bookIt.demo.service.CategoryService;
import com.bookIt.demo.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/company")
public class CompanyControllerView {

    @Autowired
    private CompanyService companySvc;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String getIndex(Model model) {
        List<Company> companies = companySvc.findAll();
        model.addAttribute("companies",companies);
        return "company-list";
    }

    @GetMapping("/create")
    public String getCreate(Model model) {
        List<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);
        return "company-create";
    }
}
