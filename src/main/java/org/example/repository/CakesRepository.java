package org.example.repository;

import org.example.entity.CakesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface CakesRepository extends JpaRepository<CakesEntity,Long> {
    CakesEntity findByName(String name);

}
