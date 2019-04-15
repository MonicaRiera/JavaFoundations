package org.bts_netmind.javaproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("online-order-sample.csv"));
        String categoryNames = reader.readLine();
        Map<String, String> ordersMap = new HashMap<String, String>();
        List<String> categories = Arrays.asList(categoryNames.split(","));

        while (true) {
            String order = reader.readLine();
            if (order != null) {
                List<String> orderItems = Arrays.asList(order.split(","));
                for (int i = 0; i < orderItems.size(); i++ ) {
                    ordersMap.put(categories.get(i), orderItems.get(i));
                }

                Order onlineOrder = new Order(
                        ordersMap.get("customerName"),
                        ordersMap.get("dishName"),
                        ordersMap.get("type"),
                        Boolean.valueOf(ordersMap.get("gfd")),
                        Boolean.valueOf(ordersMap.get("vgd")),
                        Boolean.valueOf(ordersMap.get("hmd")),
                        Boolean.valueOf(ordersMap.get("sfd")),
                        ordersMap.get("extras"));
                System.out.println(onlineOrder);

            } else {
                break;
            }
        }

    }
}
