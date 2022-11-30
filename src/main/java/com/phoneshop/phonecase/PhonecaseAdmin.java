
package com.phoneshop.phonecase;

public class PhonecaseAdmin {
    private String ID;
    private String color;
    private String image;


    public PhonecaseAdmin(String ID, String color, String image) {
        this.setID(ID);
        this.setColor(color);
        this.setImage(image);
    }


	public String getID() {
		return ID;
	}


	public void setID(String iD) {
		ID = iD;
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









}
