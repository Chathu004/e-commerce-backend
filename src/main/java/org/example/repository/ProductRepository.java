package org.example.repository;

import org.example.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

    ProductEntity findByName(String name);
}
