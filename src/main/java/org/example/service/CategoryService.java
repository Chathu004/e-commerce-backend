package org.example.service;

import org.example.dto.Category;
import org.example.entity.CategoryEntity;

import java.util.List;

public interface CategoryService {
    CategoryEntity createCategory(Category category);
     List<CategoryEntity> getAllCategories();

    Category getCategoryByName(String name);

    boolean deleteCategoryByName(String name);
}
