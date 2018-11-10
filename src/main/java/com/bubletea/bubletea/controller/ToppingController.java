package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.Topping;
import com.bubletea.bubletea.service.ToppingServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/store/toppings")
@RestController
public class ToppingController {

    @Autowired
    ToppingServiceImpl toppingService;

    @GetMapping
    @ResponseBody
    public List<Topping> getAllToppings() {
        return toppingService.findAll();
    }

    @GetMapping("/{toppingId}")
    @ResponseBody
    public Topping getTopping(@PathVariable("toppingId")int toppingId) {
        return toppingService.findById(toppingId);
    }
}
