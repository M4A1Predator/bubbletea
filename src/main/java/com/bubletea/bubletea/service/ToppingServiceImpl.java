package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Topping;
import com.bubletea.bubletea.repository.ToppingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToppingServiceImpl implements ToppingService {
    @Autowired
    ToppingRepository toppingRepository;

    @Override
    public List<Topping> getAllToppings() {
        return toppingRepository.findAll();
    }

    @Override
    public Topping getToppingById(int id) {
        return toppingRepository.findById(id);
    }
}
