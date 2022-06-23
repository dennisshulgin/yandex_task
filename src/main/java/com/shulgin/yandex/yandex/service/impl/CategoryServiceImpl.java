package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.repository.CategoryRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public boolean addCategory(Category category, String parentCategoryId) {
        OffsetDateTime updateDate = category.getDateTime();
        Category categoryFromDB = categoryRepo.findCategoryByCode(category.getCode());
        Category parentCategory = categoryRepo.findCategoryByCode(parentCategoryId);
        if(parentCategoryId != null && parentCategory == null) {
            parentCategory = new Category(parentCategoryId, "undefined", updateDate, null);
            categoryRepo.save(parentCategory);
        }
        if(categoryFromDB != null) {
            categoryFromDB.setName(category.getName());
            categoryFromDB.setDateTime(updateDate);
            categoryFromDB.setParentCategory(parentCategory);
            categoryRepo.save(categoryFromDB);
        } else {
            category.setParentCategory(parentCategory);
            categoryRepo.save(category);
        }
        while(parentCategory != null) {
            parentCategory.setDateTime(updateDate);
            categoryRepo.save(parentCategory);
            parentCategory = parentCategory.getParentCategory();
        }
        return true;
    }

    public boolean deleteCategory(String code) {
        Category categoryFromDB = categoryRepo.findCategoryByCode(code);
        if(categoryFromDB == null) {
            return false;
        }
        categoryRepo.delete(categoryFromDB);
        return true;
    }

    public Category findCategoryByCode(String code) {
        return categoryRepo.findCategoryByCode(code);
    }

    public void saveCategory(Category category) {
        categoryRepo.save(category);
    }
}
