package com.bubletea.bubletea.controller;

import com.bubletea.bubletea.entity.*;
import com.bubletea.bubletea.model.CustomPrincipal;
import com.bubletea.bubletea.model.request.OrderItemRequest;
import com.bubletea.bubletea.model.request.OrderRequest;
import com.bubletea.bubletea.service.OrderService;
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
        List<OrderItem> orderItems = new ArrayList<OrderItem>();
        List<OrderItemRequest> orderItemRequests = orderRequest.getOrderItems();

        // Construct order items data
        for (OrderItemRequest oir: orderItemRequests) {
            OrderItem oi = new OrderItem();
            oi.setMenu(new Menu(oir.getMenuId()));
            oi.setOrder(order);

            if (oir.getToppingId() != 0) {
                oi.setTopping(new Topping(oir.getToppingId()));
            }
            oi.setPrice(0.00);
            orderItems.add(oi);
        }

        // Set user data for order
        User user = userService.getUserById(principal.getId());
        order.setUser(user);
        order.setTotalPrice(0);
        order.setOrderItems(orderItems);

        // Save order
        orderService.saveOrder(order);

        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }
}
