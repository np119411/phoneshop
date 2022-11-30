package com.phoneshop.shopping;

import com.phoneshop.phonecase.PhonecaseDTO;
import com.phoneshop.phones.PhoneDTO;

public class LineItem {
	private PhoneDTO phoneDTO;
	private PhonecaseDTO phonecaseDTO;
	private int quantity;
	private int pcquantity;
	private long subPrice = 0;

	public LineItem(PhoneDTO phoneDTO, int quantity) {
		super();
		this.phoneDTO = phoneDTO;
		this.quantity = quantity;
		calculateSubPrice();
	}
	
	public LineItem(PhonecaseDTO phonecaseDTO, int quantity) {
		super();
		this.phonecaseDTO = phonecaseDTO;
		this.pcquantity = quantity;
		calculateSubPrice();
	}	


	public void calculateSubPrice() {
		if (phoneDTO != null) {
			subPrice = phoneDTO.getPrice() * quantity;
		} else {
			subPrice = 0;
		}
	}

	public PhoneDTO getPhoneDTO() {
		return phoneDTO;
	}

	public void setPhoneDTO(PhoneDTO phoneDTO) {
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

	public int getPcquantity() {
		return pcquantity;
	}

	public void setPcquantity(int pcquantity) {
		this.pcquantity = pcquantity;
	}



}
