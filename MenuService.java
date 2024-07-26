package com.restaurant.model;

import com.restaurant.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<MenuItem> menu;

    public MenuService() {
        this.menu = new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public MenuItem findMenuItemByName(String name) {
        for (MenuItem item : menu) {
            if (item.getName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }
}
