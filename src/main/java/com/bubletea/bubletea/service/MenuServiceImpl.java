package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Menu;
import com.bubletea.bubletea.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    MenuRepository menuRepository;

    @Override
    public List<Menu> getAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public Menu getMenuById(int id) {
        return menuRepository.findById(id);
    }
}
