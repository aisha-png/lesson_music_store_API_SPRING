package com.bnta.music_store.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column(name = "description")
    private String desc;

    @Column
    private float price;

//    todo: fill in mappedBy
    @ManyToMany(mappedBy = "products")
    @JsonIgnoreProperties({"products"})
    private List<Purchase> purchases;

    protected Product(){}

    public Product(String title, String desc, float price) {
        this.title = title;
        this.desc = desc;
        this.price = price;
        this.purchases = new ArrayList<>();
    }

//    public Product(){} can be used as well

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<Purchase> getPurchases() {
        return purchases;
    }

    public void setPurchases(List<Purchase> purchases) {
        this.purchases = purchases;
    }

    public void addPurchase(Purchase purchase){
        this.purchases.add(purchase);
    }

    public boolean removePurchase(Purchase purchase){
        return this.purchases.remove(purchase);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", desc='" + desc + '\'' +
                ", price=" + price +
                ", purchases=" + purchases +
                '}';
    }
}
