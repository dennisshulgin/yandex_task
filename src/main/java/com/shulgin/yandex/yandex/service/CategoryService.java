package com.shulgin.yandex.yandex.service;

import com.shulgin.yandex.yandex.entity.Category;
import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    void addCategory(Category category);
    Category findCategoryById(String id);
    boolean deleteCategory(String id);
}
