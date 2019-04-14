package org.bts_netmind.javaproject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new FileReader("online-order-sample.csv"));
        String categoryNames = reader.readLine();
        List<String> orders = new ArrayList<String>();
        while (true) {
            String order = reader.readLine();
            if (order != null) {
                //List<String> orderFields = Arrays.asList(order.split(","));
                orders.add(order);
            } else {
                break;
            }
        }

        System.out.println(orders);
        
    }
}
