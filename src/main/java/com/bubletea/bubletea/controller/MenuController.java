package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.Menu;
import com.bubletea.bubletea.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
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

    @GetMapping("/{menuId}")
    public Menu getMenu(@PathVariable("menuId")int id, Principal principal) {
        Menu menu = menuService.getMenuById(id);
        return menu;
    }
}
