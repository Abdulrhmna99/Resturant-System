package com.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<MenuItem> items;
    private double total;

    public Order() {
        this.items = new ArrayList<>();
        this.total = 0;
    }

    public void addItem(MenuItem item) {
        items.add(item);
        total += item.getPrice();
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Order{" +
                "items=" + items +
                ", total=" + total +
                '}';
    }
}
