package com.shulgin.yandex.yandex.repository;

import com.shulgin.yandex.yandex.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepo extends CrudRepository<Category, Long> {
    Category findCategoryByCode(String code);
}
