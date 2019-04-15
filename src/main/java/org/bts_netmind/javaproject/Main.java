package org.bts_netmind.javaproject;

import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        OrdersManager ordersManager = new OrdersManager();
        List<Order> orders = ordersManager.readCSV("online-order-sample.csv");

        System.out.println("All orders:\n" + ordersManager.getAllOrdersToString(orders));
        System.out.println("Total number of orders:" + ordersManager.getNumberOrders(orders));
        System.out.println("Order num.2 : " + ordersManager.getOrder(orders, 1));

    }
}
