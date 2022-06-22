package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.repository.CategoryRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import com.shulgin.yandex.yandex.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    @Autowired
    private ValidationService validationService;

    public boolean addCategory(Category category, String parentCategory) {
        if(!(validationService.checkParentId(parentCategory)
            && validationService.checkCategoryPrice(category.getPrice())
            && validationService.checkName(category.getName())
            && validationService.checkCategoryId(category.getCode()))) {
            return false;
        }
        OffsetDateTime dateTime = category.getDateTime();
        Category currentCategory = categoryRepo.findCategoryByCode(category.getCode());
        Category parent = categoryRepo.findCategoryByCode(parentCategory);
        if(currentCategory != null) {
            currentCategory.setParentCategory(parent);
            categoryRepo.save(currentCategory);
        } else {
            category.setParentCategory(parent);
            categoryRepo.save(category);
        }
        while(parent != null) {
            parent.setDateTime(dateTime);
            categoryRepo.save(parent);
            parent = parent.getParentCategory();
        }
        return true;
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

    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }
}
