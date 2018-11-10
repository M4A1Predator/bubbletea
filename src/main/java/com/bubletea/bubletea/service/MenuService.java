package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Menu;

import java.util.List;

public interface MenuService {
    List<Menu> getAllMenus();

    Menu getMenuById(int id);
}
