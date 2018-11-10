package com.bubletea.bubletea.entity;

import javax.persistence.*;

@Entity
public class Menu {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private Double pricePerUnit;
    private boolean enabled;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPricePerUnit() {
        return pricePerUnit;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
