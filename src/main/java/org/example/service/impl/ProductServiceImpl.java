package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.example.entity.CategoryEntity;
import org.example.entity.ProductEntity;
import org.example.entity.UserEntity;
import org.example.repository.CategoryRepository;
import org.example.repository.ProductRepository;
import org.example.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    final ProductRepository repository;
    final CategoryRepository categoryRepository;
    final ModelMapper mapper;

    @Override
    public List<ProductEntity> getAllProducts() {
        return (List<ProductEntity>) repository.findAll();
    }

    @Override
    public boolean deleteProduct(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Product getProductId(Long id) {
        Optional<ProductEntity> byId = repository.findById(id);
        return mapper.map(byId, Product.class);
    }

    @Override
    public Product findByName(String name) {
        return mapper.map(repository.findByName(name),Product.class);
    }
    @Override
    public void addProduct(Product product) {
        // Map the DTO to an entity
        ProductEntity entity = mapper.map(product, ProductEntity.class);

        // Find the category by id
        CategoryEntity category = categoryRepository.findById(product.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"+ product.getCategoryId()));

        // Set the category in the entity
        entity.setCategory(category);
        // Set the imgURL (assuming it's already set in the product DTO)
        entity.setImgURL(product.getImgURL());
        // Save the product entity
        repository.save(entity);
    }


}



