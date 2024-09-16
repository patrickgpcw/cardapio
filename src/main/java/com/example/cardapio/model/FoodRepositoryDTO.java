package com.example.cardapio.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepositoryDTO extends JpaRepository<Food,Long> {
}
