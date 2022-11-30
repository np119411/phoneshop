package com.phoneshop.shopping;

import com.phoneshop.phonecase.PhonecaseDTO;

public class LinePhonecase {
	private PhonecaseDTO phoneDTO;
	private PhonecaseDTO phonecaseDTO;
	private int quantity;
	private long subPrice = 0;

	public LinePhonecase(PhonecaseDTO phonecase, int quantity) {
		super();
		this.phoneDTO = phonecase;
		this.quantity = quantity;
		calculateSubPrice();
	}


	public void calculateSubPrice() {
		subPrice = phoneDTO.getPrice() * quantity;
	}

	public PhonecaseDTO getPhoneDTO() {
		return phoneDTO;
	}

	public void setPhoneDTO(PhonecaseDTO phoneDTO) {
		this.phoneDTO = phoneDTO;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getSubPrice() {
		return subPrice;
	}

	public void setSubPrice(long subPrice) {
		this.subPrice = subPrice;
	}

	public PhonecaseDTO getPhonecaseDTO() {
		return phonecaseDTO;
	}

	public void setPhonecaseDTO(PhonecaseDTO phonecaseDTO) {
		this.phonecaseDTO = phonecaseDTO;
	}

}
