package org.example.service;

import org.example.dto.Cakes;
import org.example.entity.CakesEntity;

import java.util.List;

public interface CakesService {
    void addCakes(Cakes Cakes);
    List<CakesEntity> getAllCakes();
    boolean deleteCakes(Long id);
    Cakes getCakesId(Long id);
    Cakes findByName(String name);
}
