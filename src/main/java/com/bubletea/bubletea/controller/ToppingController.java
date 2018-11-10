package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.Topping;
import com.bubletea.bubletea.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store/toppings")
@RestController
public class ToppingController {

    @Autowired
    ToppingService toppingService;

    @GetMapping
    @ResponseBody
    public List<Topping> getAllToppings() {
        return toppingService.getAllToppings();
    }

    @GetMapping("/{toppingId}")
    @ResponseBody
    public Topping getTopping(@PathVariable("toppingId")int toppingId) {
        return toppingService.getToppingById(toppingId);
    }
}
