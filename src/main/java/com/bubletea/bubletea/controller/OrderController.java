package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.Order;
import com.bubletea.bubletea.entity.User;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.model.request.OrderRequest;
import com.bubletea.bubletea.service.OrderService;
import com.bubletea.bubletea.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RequestMapping("/store/orders")
@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @Autowired
    UserService userService;

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{orderId}")
    public Order getOrder(@PathVariable("orderId") int id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public ResponseEntity<String> addOrder(CustomPrincipal principal, @RequestBody OrderRequest orderRequest){
        Order order = new Order();
        User user = userService.getUserById(principal.getId());
        order.setUser(user);
        order.setTotalPrice(0);

        orderService.saveOrder(order);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
