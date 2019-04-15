package org.bts_netmind.javaproject.service;

import org.bts_netmind.javaproject.model.Dish;
import org.bts_netmind.javaproject.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.*;

public class OrdersManager implements OnlineOrderOps {

    public OrdersManager(){}

    // Reads the CSV file with BufferedReader and creates a Map with every category name and each value for each order,
    // so if the columns are in a different order, it does not affect the result. Then, it adds it creates the order
    // itself and returns a list of orders.
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

    public void writeCSV(List<Order> orders) throws Exception{
        PrintWriter writer = new PrintWriter("online-order-sample.csv");

        writer.println("customerName,dishName,type,gfd,vgd,hmd,sfd,extras");

        for (Order order : orders) {
            writer.println(order.getCustomerName() + ","
                    + order.getDish().getDishName() + ","
                    + order.getType() + ","
            + order.getDish().isGlutenFree() + ","
            + order.getDish().isVegetarian() + ","
            + order.getDish().isHalalMeat() + ","
            + order.getDish().isSeafoodFree() + ","
            + order.getDish().getExtras());
        }

        writer.close();
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
        return (Dish) dishList.get(dishIndex);
    }

    public String getAllDishToString(List dishList) {
        String result ="";
        for (Object dish : dishList) {
            result += dish.toString() + "\n";
        }
        return result;
    }

    public List getDishesByType(List dishList, String dishType) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishList) {
            if (dish.getClass().getName().contains(dishType)) {
                result.add(dish);
            }
        }
        return result;
    }

    public List getDishesByFeature(List dishList, String feature) {
        List<Object> result = new ArrayList<Object>();
        for (Object dishInList : dishList) {
            Dish dish = (Dish) dishInList;
            if (dish.isGlutenFree() && feature.equals("gfd")) {
                result.add(dish);
            } else if (dish.isVegetarian() && feature.equals("vgd")) {
                result.add(dish);
            } else if (dish.isHalalMeat() && feature.equals("hmd")) {
                result.add(dish);
            } else if (dish.isSeafoodFree() && feature.equals("sfd")) {
                result.add(dish);
            }
        }

        return result;
    }

    public String getStatsByDishType(List dishList, String dishType) {
        float total = dishList.size();
        List<Object> filtered = getDishesByFeature(dishList, dishType);
        float stats = ((float) filtered.size() / total) * 100;
        return stats + "% of " + total + " meals ordered are " + dishType;
    }
}
