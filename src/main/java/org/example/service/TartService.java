package org.example.service;

import org.example.dto.Tarts;
import org.example.entity.TartsEntity;

import java.util.List;

public interface TartService {
    void addTarts(Tarts Tarts);
    List<TartsEntity> getAllTarts();
    boolean deleteTarts(Long id);
    Tarts getTartsId(Long id);
    Tarts findByName(String name);

}
