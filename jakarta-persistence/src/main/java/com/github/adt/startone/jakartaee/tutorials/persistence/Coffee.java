package com.github.adt.startone.jakartaee.tutorials.persistence;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Coffee implements Serializable {
    private static final long serialVersionUID = 1L;

    //======================================================================
    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String price;

    //======================================================================
    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    //======================================================================
    // Setters
    public void setId(Long _id) {
        id = _id;
    }

    public void setName(String _name) {
        name = _name;
    }

    public void setPrice(String _price) {
        price = _price;
    }
}
