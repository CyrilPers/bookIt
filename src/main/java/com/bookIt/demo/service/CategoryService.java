package com.bookIt.demo.service;

import com.bookIt.demo.model.Category;
import com.bookIt.demo.exception.FunctionalException;
import com.bookIt.demo.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.bookIt.demo.enums.code.category.CategoryError.CATEGORY_NOT_FOUND;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepo;

    public List<Category> findAll() {
        return categoryRepo.findAll();
    }

    public Category save(Category category) {
        return categoryRepo.save(category);
    }

    public Category findById(Integer categoryId) throws FunctionalException {
        return categoryRepo.findById(categoryId).orElseThrow(() -> new FunctionalException(CATEGORY_NOT_FOUND));
    }
}
