package org.example.repository;

import org.example.entity.CommonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Repository
@Service
public interface CommonRepository extends JpaRepository<CommonEntity,Long> {
//    List<CommonEntity> findByCategory(String category);
List<CommonEntity> findByCategoryCategoryId(Long categoryId);
Optional<CommonEntity> findByCategoryCategoryIdAndId(Long categoryId, Long itemId);


}
