package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Gifts;
import org.example.entity.GiftsEntity;
import org.example.service.GiftsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/gifts")
@CrossOrigin
public class GiftsController {
    final GiftsService giftsService;
    @PostMapping("/addGifts")
    public void addGifts(@RequestBody Gifts Gifts){
        giftsService.addGifts(Gifts);
    }
    @GetMapping("/getAllGifts")
    public List<GiftsEntity> getAllGifts(){
        return giftsService.getAllGifts();
    }
    @GetMapping("/get/subCategory/{name}")
    public Gifts findByName(@PathVariable String name){
        return giftsService.findByName(name);
    }
    @GetMapping("get/search-id/{id}")
    public Gifts getGiftsId(@PathVariable Long id){
        return giftsService.getGiftsId(id);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteGifts(@PathVariable Long id){
        giftsService.deleteGifts(id);
        return "delete Gifts!";
    }

}
