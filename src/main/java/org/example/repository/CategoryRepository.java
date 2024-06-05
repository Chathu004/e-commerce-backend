package org.example.repository;

import org.example.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface CategoryRepository extends JpaRepository<CategoryEntity,Long> {
    CategoryEntity getByName(String name);
}
