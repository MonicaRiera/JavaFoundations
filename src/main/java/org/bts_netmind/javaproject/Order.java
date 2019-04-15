package org.bts_netmind.javaproject;

public class Order {

    private String customerName;
    private enum Type {st, mc, ds}
    private Type type;
    private Dish dish;



    public Order (String customerName, String dishName, String type, boolean gfd, boolean vgd, boolean hmd, boolean sfd, String extras) {
        this.type = Type.valueOf(type);
        this.customerName = customerName;

        if (this.type == Type.st) {
            this.dish = new Starter(dishName, gfd, vgd, hmd, sfd, extras);
        } else if (this.type == Type.mc) {
            this.dish = new MainCourse(dishName, gfd, vgd, hmd, sfd, extras);
        } else if (this.type == Type.ds) {
            this.dish = new Dessert(dishName, gfd, vgd, hmd, sfd, extras);
        }

    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public String toString() {
        String result = customerName + " ordered " + this.dish.toString();
        return result;
    }
}
