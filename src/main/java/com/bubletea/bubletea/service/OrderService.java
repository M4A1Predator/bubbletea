package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    Order getOrderById(int id);

    Order saveOrder(Order order);
}
