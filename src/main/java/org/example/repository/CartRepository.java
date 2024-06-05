package org.example.repository;

import org.example.entity.CartEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Repository
@Service
public interface CartRepository extends JpaRepository<CartEntity,Long> {
    List<CartEntity> findByUserEntityUserId(Long userId);

}
