package org.bts_netmind.javaproject;

public class Order extends Dish{

    private String customerName;


    public Order (String customerName, String dishName, String type, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String extras) {
        super(dishName, type, gfd, vgd, hmd, sfd, extras);
        this.customerName = customerName;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }



    @Override
    public String toString() {
        String result = customerName + " ordered " + super.toString();
        return result;
    }
}
