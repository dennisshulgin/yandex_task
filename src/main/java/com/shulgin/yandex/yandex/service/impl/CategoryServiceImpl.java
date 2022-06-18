package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.repository.CategoryRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public void addCategory(Category category, String parentCategory) {
        Category currentCategory = categoryRepo.findCategoryByCode(category.getCode());
        Category parent = categoryRepo.findCategoryByCode(parentCategory);
        if(currentCategory != null) {
            currentCategory.setParentCategory(parent);
            categoryRepo.save(currentCategory);
        } else {
            category.setParentCategory(parent);
            categoryRepo.save(category);
        }
    }

    public boolean deleteCategory(String code) {
        Category category = categoryRepo.findCategoryByCode(code);
        if(category == null) {
            return false;
        }
        categoryRepo.delete(category);
        return true;

    }

    public Category findCategoryByCode(String code) {
        return categoryRepo.findCategoryByCode(code);
    }
}
