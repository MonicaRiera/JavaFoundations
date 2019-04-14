package org.bts_netmind.javaproject;

import java.util.List;

public class OrdersManager implements OnlineOrderOps {

    public OrdersManager(){}

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
