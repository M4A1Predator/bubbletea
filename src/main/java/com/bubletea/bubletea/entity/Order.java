package com.bubletea.bubletea.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.Temporal;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "[order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private double totalPrice;

    private String note;

    @CreatedDate
    private Date createdAt;

    public int getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getNote() {
        return note;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
