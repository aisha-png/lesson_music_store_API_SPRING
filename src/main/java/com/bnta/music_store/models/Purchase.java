package com.bnta.music_store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "purchases")
public class Purchase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties({"purchases"})
    private User user;
//    purchase can have many users

    @ManyToMany()
    @JoinTable(name = "purchases_products",
            joinColumns = {@JoinColumn(name = "purchase_id", nullable = false)},
            inverseJoinColumns = {@JoinColumn(name = "product_id", nullable = false)})
    @JsonIgnoreProperties({"purchases"})
    private List<Product> products;

    public Purchase(User user, List<Product> products) {
        this.user = user;
        this.products = products;
    }

    protected Purchase(){}

    public long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", user=" + user +
                ", products=" + products +
                '}';
    }
}
