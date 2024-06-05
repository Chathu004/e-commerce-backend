package org.example.repository;

import org.example.entity.TartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface TartsRepository extends JpaRepository<TartsEntity,Long> {
    TartsEntity findByName(String name);

}
