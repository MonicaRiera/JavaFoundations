package org.bts_netmind.javaproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class OrdersManager implements OnlineOrderOps {

    public OrdersManager(){}

    public List<Order> readCSV(String fileName) throws Exception{
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String categoryNames = reader.readLine();
        Map<String, String> ordersMap = new HashMap<String, String>();
        List<String> categories = Arrays.asList(categoryNames.split(","));
        List<Order> orders = new ArrayList<Order>();

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

                orders.add(onlineOrder);

            } else {
                break;
            }
        }
        return orders;
    }

    public int getNumberOrders(List orderList) {
        return orderList.size();
    }

    public Object getOrder(List orderList, int orderIndex) {
        return orderList.get(orderIndex);
    }

    public String getAllOrdersToString(List orderList) {
        String result ="";
        for (Object order : orderList) {
            result += order.toString() + "\n";
        }
        return result;
    }

    public Dish getDish(List dishList, int dishIndex) {
        return null;
    }

    public String getAllDishToString(List dishList) {
        return null;
    }

    public List getDishesByType(List dishList, String dishType) {
        return null;
    }

    public List getDishesByFeature(List dishList, String feature) {
        return null;
    }

    public String getStatsByDishType(List dishList, String dishType) {
        return null;
    }
}
