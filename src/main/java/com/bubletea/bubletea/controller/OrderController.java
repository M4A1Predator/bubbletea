package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.*;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.model.dto.OrderItemDto;
import com.bubletea.bubletea.model.dto.OrderDto;
import com.bubletea.bubletea.service.MenuService;
import com.bubletea.bubletea.service.OrderService;
import com.bubletea.bubletea.service.ToppingService;
import com.bubletea.bubletea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/store/orders")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @Autowired
    MenuService menuService;

    @Autowired
    ToppingService toppingService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<String> addOrder(CustomPrincipal principal, @RequestBody OrderDto orderDto){
        Order order = new Order();
        List<OrderItem> orderItems = new ArrayList<>();
        List<OrderItemDto> orderItemDtos = orderDto.getOrderItems();
        double totalPrice = 0.00;

        // Construct order items data
        for (OrderItemDto oir: orderItemDtos) {
            OrderItem oi = new OrderItem();
            oi.setOrder(order);

            double price = 0.00;

            // Get menu data
            Menu menu = menuService.getMenuById(oir.getMenuId());
            price += menu.getPricePerUnit();
            oi.setMenu(menu);

            // Get topping data
            if (oir.getToppingId() != 0) {
                Topping topping = toppingService.getToppingById(oir.getToppingId());
                price += topping.getPricePerUnit();
                oi.setTopping(topping);
            }

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
        orderService.saveOrder(order);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
