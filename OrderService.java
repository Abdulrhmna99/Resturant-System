package com.restaurant.model;

import com.restaurant.model.Order;
import com.restaurant.model.MenuItem;

public class OrderService {
    private Order currentOrder;

    public OrderService() {
        this.currentOrder = new Order();
    }

    public void addMenuItemToOrder(MenuItem item) {
        currentOrder.addItem(item);
    }

    public Order getCurrentOrder() {
        return currentOrder;
    }

    public double calculateTotal() {
        return currentOrder.getTotal();
    }
}
