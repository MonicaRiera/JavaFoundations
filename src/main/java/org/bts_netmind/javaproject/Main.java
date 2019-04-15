package org.bts_netmind.javaproject;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        OrdersManager ordersManager = new OrdersManager();
        List<Order> orders = ordersManager.readCSV("online-order-sample.csv");
        List<Dish> dishes = Dish.dishes;

        System.out.println("All orders:\n" + ordersManager.getAllOrdersToString(orders));
        System.out.println("\nTotal number of orders:" + ordersManager.getNumberOrders(orders));
        System.out.println("\nOrder num.2:\n" + ordersManager.getOrder(orders, 1));
        System.out.println("\nDish num.3:\n" + ordersManager.getDish(dishes, 2));
        System.out.println("\nAll dishes:\n" + ordersManager.getAllDishToString(dishes));
        System.out.println("\nStarters:\n" + ordersManager.getDishesByType(dishes, "Starter"));
        System.out.println("\nVegetarian meals:\n" + ordersManager.getDishesByFeature(dishes, "vgd"));
        System.out.println("\nStats of Gluten Free:\n" + ordersManager.getStatsByDishType(dishes, "gfd"));
    }
}
