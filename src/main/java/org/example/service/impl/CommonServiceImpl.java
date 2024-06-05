package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cakes;
import org.example.dto.Common;
import org.example.dto.Product;
import org.example.entity.CakesEntity;
import org.example.entity.CategoryEntity;
import org.example.entity.CommonEntity;
import org.example.entity.ProductEntity;
import org.example.repository.CakesRepository;
import org.example.repository.CategoryRepository;
import org.example.repository.CommonRepository;
import org.example.service.CommonService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommonServiceImpl implements CommonService {
    final CommonRepository repository;
    final CategoryRepository categoryRepository;
    final ModelMapper mapper;

    @Override
    public void addCommon(Common common) {
        // Map the DTO to an entity
        CommonEntity entity = mapper.map(common, CommonEntity.class);

        // Find the category by id
        CategoryEntity category = categoryRepository.findById(common.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"+ common.getCategoryId()));

        // Set the category in the entity
        entity.setCategory(category);
        // Set the imgURL (assuming it's already set in the product DTO)
        entity.setImgURL(common.getImgURL());
        // Save the product entity
        repository.save(entity);
    }


    @Override
    public List<CommonEntity> getAllCommon() {
        return null;
    }

    @Override
    public boolean deleteCommon(Long id) {
        return false;
    }

    @Override
    public Common getCommonId(Long id) {
        Optional<CommonEntity> byId = repository.findById(id);
        return mapper.map(byId, Common.class);
    }

    @Override
    public List<Common> getCommonByCategoryId(Long categoryId) {
        List<CommonEntity> entities = repository.findByCategoryCategoryId(categoryId);
        return entities.stream().map(e -> mapper.map(e, Common.class)).collect(Collectors.toList());
    }

    @Override
    public Common getCommonByCategoryIdAndItemId(Long categoryId, Long itemId) {
        Optional<CommonEntity> entity = repository.findByCategoryCategoryIdAndId(categoryId, itemId);
        return entity.map(value -> mapper.map(value, Common.class)).orElse(null);
    }
//    @Override
//    public List<CommonEntity> getCommonByCategory(String category) {
//        return repository.findByCategory(category);
//    }

//    @Override
//    public Common getCommonById(Long id) {
////        return repository.findById(id).orElseThrow(() -> new ProductNotFoundException(id));
//        Optional<CommonEntity> byId = repository.findById(id);
//        return mapper.map(byId, Common.class);
//    }
}
