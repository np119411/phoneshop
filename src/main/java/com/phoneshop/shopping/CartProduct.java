
package com.phoneshop.shopping;


public class CartProduct {
    private String ID;
    private String name;
    private int price;
    private String image;
    private int quantity;

    public CartProduct() {
    }

    public CartProduct(String ID, String name, int price, String image, int quantity) {
        this.ID = ID;
        this.name = name;
        this.price = price;
        this.image = image;
        this.quantity = quantity;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
