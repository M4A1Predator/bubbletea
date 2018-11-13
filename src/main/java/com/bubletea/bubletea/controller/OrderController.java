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
import org.springframework.security.access.prepost.PreAuthorize;
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
    public List<Order> getOrders(CustomPrincipal principal) {
        List<Order> orders = orderService.getOrdersByUserId(principal.getId());
        return orders;
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<Order> addOrder(CustomPrincipal principal, @RequestBody OrderDto orderDto){
        Order order = orderService.saveOrder(orderDto, principal);
        return new ResponseEntity<>(order, HttpStatus.CREATED);
    }
}
