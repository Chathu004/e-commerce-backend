package org.example.service;

import org.example.dto.Gifts;
import org.example.entity.GiftsEntity;

import java.util.List;

public interface GiftsService {
    void addGifts(Gifts Gifts);
    List<GiftsEntity> getAllGifts();
    boolean deleteGifts(Long id);
    Gifts getGiftsId(Long id);
    Gifts findByName(String name);
}
