package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    boolean addCategory(Category category, String parentCategory);
    Category findCategoryByCode(String Code);
    boolean deleteCategory(String code);
    void saveCategory(Category category);
}
