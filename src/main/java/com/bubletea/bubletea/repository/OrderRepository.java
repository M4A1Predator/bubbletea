package com.bubletea.bubletea.repository;

import com.bubletea.bubletea.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    List<Order> findAll();

    Order findById(int id);
}
