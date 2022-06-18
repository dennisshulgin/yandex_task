package com.shulgin.yandex.yandex.service.impl;

import com.shulgin.yandex.yandex.entity.Category;
import com.shulgin.yandex.yandex.repository.CategoryRepo;
import com.shulgin.yandex.yandex.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepo categoryRepo;

    public void addCategory(Category category) {
        categoryRepo.save(category);
    }

    public Category findCategoryById(String id) {
        return categoryRepo.findCategoryById(id);
    }
}
