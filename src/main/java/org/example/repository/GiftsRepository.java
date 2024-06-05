package org.example.repository;

import org.example.entity.GiftsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface GiftsRepository extends JpaRepository<GiftsEntity,Long> {
    GiftsRepository findByName(String name);

}
