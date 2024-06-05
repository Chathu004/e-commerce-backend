package org.example.service;

import org.example.dto.Cakes;
import org.example.dto.Common;
import org.example.dto.Product;
import org.example.entity.CommonEntity;
import org.example.entity.ProductEntity;

import java.util.List;

public interface CommonService {
    void addCommon(Common common);
    List<CommonEntity> getAllCommon();
    boolean deleteCommon(Long id);
    Common getCommonId(Long id);
    List<Common> getCommonByCategoryId(Long categoryId);
    Common getCommonByCategoryIdAndItemId(Long categoryId, Long itemId);


//    List<CommonEntity> getCommonByCategory(String category);
//    Common getCommonById(Long id);
}
