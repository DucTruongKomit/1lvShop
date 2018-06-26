package model;

import interfaces.Buyable;

public abstract class Product implements Buyable {
	protected String name;
	protected double price;
	protected int quantity;
	protected AgeRestriction ageRestriction;
	
	@Override
	public abstract double getPrice();

	@Override
	public String toString() {
		return "Name = " + this.name + "; quantity = " + this.quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public AgeRestriction getAgeRestriction() {
		return ageRestriction;
	}

	public void setAgeRestriction(AgeRestriction ageRestriction) {
		this.ageRestriction = ageRestriction;
	}

	public Product(String name, double price, int quantity, AgeRestriction ageRestriction) {
		super();
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.ageRestriction = ageRestriction;
	}

	public Product() {
		super();
	}
	
	
	
}
