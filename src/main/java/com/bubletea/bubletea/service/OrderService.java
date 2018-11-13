package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Order;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.model.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();

    List<Order> getOrdersByUserId(int userId);

    Order getOrderById(int id);

    Order saveOrder(OrderDto orderDto, CustomPrincipal principal);
}
