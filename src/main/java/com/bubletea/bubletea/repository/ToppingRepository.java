package com.bubletea.bubletea.repository;

import com.bubletea.bubletea.entity.Topping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToppingRepository extends JpaRepository<Topping, Integer> {
    List<Topping> findAll();

    Topping findById(int id);
}
