package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Product;
import org.example.entity.ProductEntity;
import org.example.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping("/cookies")
public class ProductController {
    final ProductService productService;

    @PostMapping("/addCookies")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
    @GetMapping("/getAllCookies")
    public List<ProductEntity> getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("/get/subCategory/{name}")
    public Product findByName(@PathVariable String name){
        return productService.findByName(name);
    }
    @GetMapping("get/search-id/{id}")
    public Product getProductId(@PathVariable Long id){
        return productService.getProductId(id);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
        return "delete product!";
    }


}
