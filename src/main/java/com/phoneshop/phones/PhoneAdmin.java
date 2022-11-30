
package com.phoneshop.phones;

public class PhoneAdmin {
    private String ID;
    private String name;
    private String description;
    private String brand;
    private int price;
    private int priceDel;
    private String createDate;
    private String image;
    private String typeID;
    private int quantity;

    public PhoneAdmin(String ID, String name, String description, String brand, int price,int priceDel, String createDate, String image, String typeID, int quantity) {
        this.ID = ID;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.price = price;
        this.priceDel = priceDel;
        this.createDate = createDate;
        this.image = image;
        this.typeID = typeID;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setAuthor(String brand) {
        this.brand = brand;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getPriceDel() {
        return priceDel;
    }

    public void setPriceDel(int priceDel) {
        this.priceDel = priceDel;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTypeID() {
        return typeID;
    }

    public void setTypeID(String typeID) {
        this.typeID = typeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
