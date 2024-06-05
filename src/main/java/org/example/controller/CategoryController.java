package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Category;
import org.example.entity.CategoryEntity;
import org.example.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/category")
@RequiredArgsConstructor
public class CategoryController {
    final CategoryService service;
    @PostMapping("/add")
    public ResponseEntity<CategoryEntity> createCategory(@RequestBody Category category){
        CategoryEntity entity = service.createCategory(category);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    @GetMapping("/getAll")
    public List<CategoryEntity> getAllCategories(){
        return service.getAllCategories();
    }
    @GetMapping("/get/{name}")
    public Category getCategoryByName(@PathVariable String name){
        return service.getCategoryByName(name);
    }

    @DeleteMapping("/delete/{name}")
    public Boolean deleteCategoryByName(@PathVariable String name){
        return service.deleteCategoryByName(name);
    }

}
