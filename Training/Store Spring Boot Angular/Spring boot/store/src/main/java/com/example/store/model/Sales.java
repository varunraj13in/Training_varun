package com.example.store.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Sales {
	@Id
	private int id;
	private String name;
	private String gender;
	private String brand;
	private String category;
	private int quantity;
	private int price;
	private String status;

	public Sales() {
		
	}
	
	public Sales(int id, String name, String gender, String brand, String category, int quantity, int price,
			String status) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.brand = brand;
		this.category = category;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
