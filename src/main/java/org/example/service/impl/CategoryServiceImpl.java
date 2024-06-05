package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Category;
import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    final CategoryRepository repository;
    final ModelMapper mapper;
    public CategoryEntity createCategory(Category category){
        CategoryEntity entity = new CategoryEntity();
        entity.setName(category.getName());
//        entity.setDescription(category.getDescription());

        return repository.save(entity);
    }

    @Override
    public List<CategoryEntity> getAllCategories() {
        return (List<CategoryEntity>) repository.findAll();
    }


    @Override
    public Category getCategoryByName(String name) {
        return mapper.map(repository.getByName(name),Category.class);
    }

    @Override
    public boolean deleteCategoryByName(String name) {
        Category category = getCategoryByName(name);
        repository.deleteById(category.getCategoryId());
        return true;
    }
}
