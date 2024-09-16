package com.example.cardapio.controller;

import com.example.cardapio.model.Food;
import com.example.cardapio.model.FoodRepositoryDTO;
import com.example.cardapio.model.FoodResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    FoodRepositoryDTO repository;

    @GetMapping("/all")
    public List<FoodResponseDTO> getAll(){
        List<FoodResponseDTO> foodList = (List<FoodResponseDTO>) repository.findAll().stream().map(FoodResponseDTO::new).collect(Collectors.toList());
        return foodList;
    }

    @PostMapping("/register")
    public FoodResponseDTO register(@RequestBody Food food){
        repository.save(food);
        return new FoodResponseDTO(food);
    }

}
