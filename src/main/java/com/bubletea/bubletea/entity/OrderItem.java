package com.bubletea.bubletea.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    @JsonIgnore
    private Order order;

    @ManyToOne
    @JoinColumn(name = "menu_id", nullable = false)
    private Menu menu;

    @ManyToOne
    @JoinColumn(name = "topping_id", nullable = false)
    private Topping topping;

    private double price;

    public int getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Menu getMenu() {
        return menu;
    }

    public Topping getTopping() {
        return topping;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public void setTopping(Topping topping) {
        this.topping = topping;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
