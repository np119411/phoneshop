
package com.phoneshop.orders;

public class Order {
    private String orderID;
    private String userID;
    private double totalPrice;
    private String createDate;

    public Order() {
    }

    public Order(String orderID, String userID, double totalPrice, String createDate) {
        this.orderID = orderID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.createDate = createDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
}
