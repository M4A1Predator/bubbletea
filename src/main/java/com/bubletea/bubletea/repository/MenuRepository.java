package com.bubletea.bubletea.repository;

import com.bubletea.bubletea.entity.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu, Integer> {
    List<Menu> findAll();

    Menu findById(int id);
}
