package com.bookIt.demo.restController;

import com.bookIt.demo.model.Category;
import com.bookIt.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.save(category);
    }

    @GetMapping("/all")
    public List<Category> getAllCategories() {
        return categoryService.findAll();
    }
}
