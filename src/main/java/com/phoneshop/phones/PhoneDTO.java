
package com.phoneshop.phones;

public class PhoneDTO {
    private String ID;
    private String name;
    private String description;
    private String brand;
    private int price;
    private int priceDel;
    private String createDate;
    private String image;
    private int typeID;
    private int quantity;
    private String pcID;
    private String phoneID;
    private String color;
    private String imagePC;
    private int pricePC;

    public PhoneDTO(String ID, String name, String description, String brand, int price, int priceDel ,String createDate, String image, int typeID, int quantity) {
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
    
    public PhoneDTO (String phoneID, String pcID, String color, String imagePC, int pricePC) {
    	this.setPhoneID(phoneID);
    	this.setPcID(pcID);
        this.setColor(color);
        this.setImagePC(image);
        this.setPricePC(price);
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

    public void setBrand(String brand) {
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


    public int getTypeID() {
        return typeID;
    }

    public void setTypeID(int typeID) {
        this.typeID = typeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

	public String getPcID() {
		return pcID;
	}

	public void setPcID(String pcID) {
		this.pcID = pcID;
	}

	public String getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImagePC() {
		return imagePC;
	}

	public void setImagePC(String imagePC) {
		this.imagePC = imagePC;
	}

	public int getPricePC() {
		return pricePC;
	}

	public void setPricePC(int pricePC) {
		this.pricePC = pricePC;
	}
}
