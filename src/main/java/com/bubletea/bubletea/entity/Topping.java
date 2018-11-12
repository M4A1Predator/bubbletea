package com.bubletea.bubletea.entity;

import javax.persistence.*;

@Entity
public class Topping {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private double pricePerUnit;
    private boolean enabled;

    public Topping() {
    }

    public Topping(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
