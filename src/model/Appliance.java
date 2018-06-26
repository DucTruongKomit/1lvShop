package model;

public class Appliance extends ElectionsProduct {
	private final static int GUARANTEE_PERIOD = 6;
	
	
	public Appliance(String name, double price, int quantity, AgeRestriction ageRestriction) {
		super(name, price, quantity, ageRestriction, GUARANTEE_PERIOD);
	}
	
	@Override
	public double getPrice() {
		double price = super.price;
		if(this.quantity < 50) {
			return price *= 1.05;
		}
		else {
			return price;
		}
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
				 "Age restriction = " + s + " }" + System.lineSeparator();
	}
	
}
