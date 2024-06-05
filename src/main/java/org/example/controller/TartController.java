package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.dto.Tarts;
import org.example.entity.TartsEntity;
import org.example.service.TartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/tarts")
@CrossOrigin
public class TartController {
    final TartService tartService;
    @PostMapping("/addTarts")
    public void addTarts(@RequestBody Tarts Tarts){
        tartService.addTarts(Tarts);
    }
    @GetMapping("/getAllTarts")
    public List<TartsEntity> getAllTarts(){
        return tartService.getAllTarts();
    }
    @GetMapping("/get/subCategory/{name}")
    public Tarts findByName(@PathVariable String name){
        return tartService.findByName(name);
    }
    @GetMapping("get/search-id/{id}")
    public Tarts getTartsId(@PathVariable Long id){
        return tartService.getTartsId(id);
    }
    @DeleteMapping("/remove/{id}")
    public String deleteTarts(@PathVariable Long id){
        tartService.deleteTarts(id);
        return "delete Tarts!";
    }

}
