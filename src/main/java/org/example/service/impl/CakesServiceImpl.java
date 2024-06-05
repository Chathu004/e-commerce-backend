package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cakes;
import org.example.entity.CategoryEntity;
import org.example.entity.CakesEntity;
import org.example.repository.CategoryRepository;
import org.example.repository.CakesRepository;
import org.example.service.CakesService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class CakesServiceImpl implements CakesService {
    final CakesRepository repository;
    final CategoryRepository categoryRepository;
    final ModelMapper mapper;

    @Override
    public List<CakesEntity> getAllCakes() {
        return (List<CakesEntity>) repository.findAll();
    }

    @Override
    public boolean deleteCakes(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Cakes getCakesId(Long id) {
        Optional<CakesEntity> byId = repository.findById(id);
        return mapper.map(byId, Cakes.class);
    }

    @Override
    public Cakes findByName(String name) {
        return mapper.map(repository.findByName(name),Cakes.class);
    }
    @Override
    public void addCakes(Cakes Cakes) {
        // Map the DTO to an entity
        CakesEntity entity = mapper.map(Cakes, CakesEntity.class);

        // Find the category by id
        CategoryEntity category = categoryRepository.findById(Cakes.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"+ Cakes.getCategoryId()));

        // Set the category in the entity
        entity.setCategory(category);
        // Set the imgURL (assuming it's already set in the Cakes DTO)
        entity.setImgURL(Cakes.getImgURL());
        // Save the Cakes entity
        repository.save(entity);
    }

}
