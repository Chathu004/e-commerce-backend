package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Cakes;
import org.example.entity.CakesEntity;
import org.example.service.CakesService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@CrossOrigin
@RequestMapping("/cakes")
public class CakesController {
    final CakesService cakesService;
    @PostMapping("/addCakes")
    public void addCakes(@RequestBody Cakes cakes){
        cakesService.addCakes(cakes);
    }
    @GetMapping("/getAllCakes")
    public List<CakesEntity> getAllCakes(){
        return cakesService.getAllCakes();
    }
    @GetMapping("/get/subCategory/{name}")
    public Cakes findByName(@PathVariable String name){
        return cakesService.findByName(name);
    }
    @GetMapping("get/search-id/{id}")
    public Cakes getCakesId(@PathVariable Long id){
        return cakesService.getCakesId(id);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteCakes(@PathVariable Long id){
        cakesService.deleteCakes(id);
        return "delete Cakes!";
    }

}
