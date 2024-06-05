package org.example.service;

import org.example.dto.Product;
import org.example.entity.ProductEntity;

import java.io.IOException;
import java.util.List;

public interface ProductService {
//    Product addProduct(Product product) throws IOException;

    void addProduct(Product product);
    List<ProductEntity> getAllProducts();
    boolean deleteProduct(Long id);
    Product getProductId(Long id);
    Product findByName(String name);

}
