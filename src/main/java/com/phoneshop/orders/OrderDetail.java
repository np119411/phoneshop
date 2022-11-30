
package com.phoneshop.orders;

public class OrderDetail {
    private String detailID;
    private String orderID;
    private String productID;
    private double detailPrice;
    private int quantity;

    public OrderDetail() {
    }

    public OrderDetail(String detailID, String orderID, String productID, double detailPrice, int quantity) {
        this.detailID = detailID;
        this.orderID = orderID;
        this.productID = productID;
        this.detailPrice = detailPrice;
        this.quantity = quantity;
    }

    public String getDetailID() {
        return detailID;
    }

    public void setDetailID(String detailID) {
        this.detailID = detailID;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public double getDetailPrice() {
        return detailPrice;
    }

    public void setDetailPrice(double detailPrice) {
        this.detailPrice = detailPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
