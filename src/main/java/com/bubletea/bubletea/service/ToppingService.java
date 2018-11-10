package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Topping;

import java.util.List;

public interface ToppingService {
    List<Topping> findAll();

    Topping findById(int id);
}
