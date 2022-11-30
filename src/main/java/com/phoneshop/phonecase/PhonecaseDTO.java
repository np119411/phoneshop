
package com.phoneshop.phonecase;

public class PhonecaseDTO {
    private String pcID;
    private String phoneID;
    private String color;
    private String image;
    private int price;

    public PhonecaseDTO (String phoneID, String pcID, String color, String image, int price) {
        this.setPhoneID(phoneID);
    	this.setPcID(pcID);
        this.setColor(color);
        this.setImage(image);
        this.setPrice(price);

    }

	public String getPcID() {
		return pcID;
	}

	public void setPcID(String ID) {
		pcID = ID;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPhoneID() {
		return phoneID;
	}

	public void setPhoneID(String phoneID) {
		this.phoneID = phoneID;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
