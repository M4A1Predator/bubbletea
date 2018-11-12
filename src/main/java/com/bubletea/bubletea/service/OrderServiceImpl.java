package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.Order;
import com.bubletea.bubletea.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order saveOrder(Order order) {
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }
}
