package com.bubletea.bubletea.model.dto;

import com.bubletea.bubletea.model.dto.OrderItemDto;

import java.util.List;

public class OrderDto {
    private List<OrderItemDto> orderItems;

    public List<OrderItemDto> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDto> orderItems) {
        this.orderItems = orderItems;
    }
}
