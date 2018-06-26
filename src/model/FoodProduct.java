package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import interfaces.Expirable;

public class FoodProduct extends Product implements Expirable {
	private LocalDate expiredDate;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public LocalDate getExpiredDate() {
		return expiredDate;
	}
	public void setExpiredDate(LocalDate expiredDate) {
		this.expiredDate = expiredDate;
	}

	
	
	public FoodProduct() {
		super();
	}
	public FoodProduct(LocalDate expiredDate) {
		super();
		this.expiredDate = expiredDate;
	}
	public LocalDate getExpirationDate() {
		return this.expiredDate;
	}

	@Override
	public double getPrice() {
		double price = super.price;
		if(this.isDisconted()) {
			return price *= 0.7;
		}
		else {
			return super.price;
		}
	}
	
	private boolean isDisconted() {
		LocalDate today = LocalDate.now();
		return today.plusDays(15).isAfter(expiredDate);
	}
	
	@Override
	public String toString() {
		String s = "";
		switch(ageRestriction) {
			case None : s = "Hàng cho mọi lứa tuổi" ; break;
			case Teenager : s = "Hàng cho tuổi teen" ; break;
			case Adult : s = "Hàng cho người lớn";break;
			default : s = "Nhập sai";break;
		}
		return "{FoodProduct: " + System.lineSeparator()
				+ super.toString() + System.lineSeparator()
				+ "Price = " + this.getPrice() + System.lineSeparator() +
				 "Age restriction = " + s + System.lineSeparator() +
				"ExpiredDate = " + this.expiredDate + " }" +System.lineSeparator();
	}
	public FoodProduct(String name, double price, int quantity, AgeRestriction ageRestriction, LocalDate expiredDate) {
		super(name, price, quantity, ageRestriction);
		this.expiredDate = expiredDate;
	}
	
	
}
