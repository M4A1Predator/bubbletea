package com.bubletea.bubletea.service;

import com.bubletea.bubletea.entity.*;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.model.dto.OrderDto;
import com.bubletea.bubletea.model.dto.OrderItemDto;
import com.bubletea.bubletea.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    MenuService menuService;

    @Autowired
    ToppingService toppingService;

    @Autowired
    UserService userService;

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public List<Order> getOrdersByUserId(int userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders;
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepository.findById(id);
    }

    @Override
    @Transactional
    public Order saveOrder(OrderDto orderDto, CustomPrincipal principal) {
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItems();
        double totalPrice = 0.00;

        // Construct order items data
        for (OrderItemDto oir: orderItemDtos) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);

            String itemName = "";
            double price = 0.00;

            // Get menu data
            Menu menu = menuService.getMenuById(oir.getMenuId());
            price += menu.getPricePerUnit();
            itemName += menu.getName();
            oi.setMenu(menu);

            // Get topping data
            if (oir.getToppingId() != 0) {
                Topping topping = toppingService.getToppingById(oir.getToppingId());
                price += topping.getPricePerUnit();
                itemName += " + topping: " + topping.getName();
                oi.setTopping(topping);
            }

            oi.setName(itemName);

            // Calculate price
            oi.setPrice(price);
            totalPrice += price;

            // Add to list
            orderItems.add(oi);
        }

        // Set user data for order
        User user = userService.getUserById(principal.getId());
        order.setUser(user);
        order.setTotalPrice(totalPrice);
        order.setOrderItems(orderItems);

        // Save order
        Order savedOrder = orderRepository.save(order);

        return savedOrder;
    }
}
