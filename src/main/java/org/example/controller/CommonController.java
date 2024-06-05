package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Common;
import org.example.dto.Product;
import org.example.service.CommonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
@RequiredArgsConstructor
@RequestMapping("/product")
public class CommonController {
    final CommonService commonService;

    @PostMapping("addAllProduct")
    public void addCommon(@RequestBody Common common){
        commonService.addCommon(common);
    }
    @GetMapping("get/search/{id}")
    public Common getCommonId(@PathVariable Long id){
        return commonService.getCommonId(id);
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<Common>> getProductsByCategoryId(@PathVariable Long categoryId) {
        List<Common> products = commonService.getCommonByCategoryId(categoryId);
        return ResponseEntity.ok(products);
    }
    @GetMapping("/category/{categoryId}/item/{itemId}")
    public ResponseEntity<Common> getCommonByCategoryIdAndItemId(@PathVariable Long categoryId, @PathVariable Long itemId) {
        Common common = commonService.getCommonByCategoryIdAndItemId(categoryId, itemId);
        if (common != null) {
            return ResponseEntity.ok(common);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

//    @GetMapping("/{type}/get/search-id/{id}")
//    public ResponseEntity<Common> getCommon(@PathVariable String type,@PathVariable Long id){
//        Common common = commonService.getCommonById(id);
//        return ResponseEntity.ok(common);
//    }


}
