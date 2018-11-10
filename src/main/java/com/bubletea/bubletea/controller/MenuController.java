package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.Menu;
import com.bubletea.bubletea.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/store/menus")
@RestController
public class MenuController {
    @Autowired
    MenuService menuService;

    @GetMapping
    public List<Menu> getMenus(){
        return menuService.getAllMenus();
    }
}
