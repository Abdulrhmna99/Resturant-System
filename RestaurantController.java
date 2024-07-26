package com.restaurant.model;

import com.restaurant.model.MenuItem;
import com.restaurant.model.MenuService;
import com.restaurant.model.OrderService;

import java.util.Scanner;

public class RestaurantController {
    private final MenuService menuService;
    private final OrderService orderService;

    public RestaurantController() {
        this.menuService = new MenuService();
        this.orderService = new OrderService();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Add Menu Item");
            System.out.println("2. Show Menu");
            System.out.println("3. Place Order");
            System.out.println("4. Show Order");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter item name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter item price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    MenuItem item = new MenuItem(name, price);
                    menuService.addMenuItem(item);
                    break;
                case 2:
                    System.out.println("Menu:");
                    for (MenuItem menuItem : menuService.getMenu()) {
                        System.out.println(menuItem);
                    }
                    break;
                case 3:
                    System.out.print("Enter item name to order: ");
                    String orderName = scanner.nextLine();
                    MenuItem orderedItem = menuService.findMenuItemByName(orderName);
                    if (orderedItem != null) {
                        orderService.addMenuItemToOrder(orderedItem);
                    } else {
                        System.out.println("Item not found.");
                    }
                    break;
                case 4:
                    System.out.println("Current Order:");
                    System.out.println(orderService.getCurrentOrder());
                    System.out.println("Total: $" + orderService.calculateTotal());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
