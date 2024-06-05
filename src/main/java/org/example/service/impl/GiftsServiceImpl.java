package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Gifts;
import org.example.entity.GiftsEntity;
import org.example.entity.CategoryEntity;
import org.example.repository.GiftsRepository;
import org.example.repository.CategoryRepository;
import org.example.service.GiftsService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class GiftsServiceImpl implements GiftsService {
    final GiftsRepository repository;
    final CategoryRepository categoryRepository;
    final ModelMapper mapper;

    @Override
    public List<GiftsEntity> getAllGifts() {
        return (List<GiftsEntity>) repository.findAll();
    }

    @Override
    public boolean deleteGifts(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Gifts getGiftsId(Long id) {
        Optional<GiftsEntity> byId = repository.findById(id);
        return mapper.map(byId, Gifts.class);
    }

    @Override
    public Gifts findByName(String name) {
        return mapper.map(repository.findByName(name),Gifts.class);
    }
    @Override
    public void addGifts(Gifts Gifts) {
        // Map the DTO to an entity
        GiftsEntity entity = mapper.map(Gifts, GiftsEntity.class);

        // Find the category by id
        CategoryEntity category = categoryRepository.findById(Gifts.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"+ Gifts.getCategoryId()));

        // Set the category in the entity
        entity.setCategory(category);
        // Set the imgURL (assuming it's already set in the Gifts DTO)
        entity.setImgURL(Gifts.getImgURL());
        // Save the Gifts entity
        repository.save(entity);
    }

}
