package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dto.Tarts;
import org.example.entity.TartsEntity;
import org.example.entity.CategoryEntity;
import org.example.repository.CategoryRepository;
import org.example.repository.TartsRepository;
import org.example.service.TartService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class TartsServiceImpl implements TartService {
    final TartsRepository repository;
    final CategoryRepository categoryRepository;
    final ModelMapper mapper;

    @Override
    public List<TartsEntity> getAllTarts() {
        return (List<TartsEntity>) repository.findAll();
    }

    @Override
    public boolean deleteTarts(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Tarts getTartsId(Long id) {
        Optional<TartsEntity> byId = repository.findById(id);
        return mapper.map(byId, Tarts.class);
    }

    @Override
    public Tarts findByName(String name) {
        return mapper.map(repository.findByName(name),Tarts.class);
    }
    @Override
    public void addTarts(Tarts Tarts) {
        // Map the DTO to an entity
        TartsEntity entity = mapper.map(Tarts, TartsEntity.class);

        // Find the category by id
        CategoryEntity category = categoryRepository.findById(Tarts.getCategoryId())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"+ Tarts.getCategoryId()));

        // Set the category in the entity
        entity.setCategory(category);
        // Set the imgURL (assuming it's already set in the Tarts DTO)
        entity.setImgURL(Tarts.getImgURL());
        // Save the Tarts entity
        repository.save(entity);
    }

}
