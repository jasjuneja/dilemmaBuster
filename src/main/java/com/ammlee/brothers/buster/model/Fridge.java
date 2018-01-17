package com.ammlee.brothers.buster.model;

import java.util.List;

public class Fridge {

    String userId;
    String name;
    List<Item> items;

    public String getUserId() {
        return userId;
    }

    public Fridge(String userId, String name, List<Item> items) {
        this.userId = userId;
        this.name = name;
        this.items = items;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
