package model;

public class Computer extends ElectionsProduct {
	private final static int GUARANTEE_PERIOD = 24;
	
	 public Computer(
	            String name,
	            double price,
	            int quantity,
	            AgeRestriction ageRestriction) {
	        super(name, price, quantity, ageRestriction, GUARANTEE_PERIOD);
	    }
	
	@Override
	public double getPrice() {
		double price = super.price;
		if(this.quantity > 1000) {
			return price *= 0.95;
		}
		else {
			return price;
		}
	}

	@Override
	public String toString() {
		String s = "";
		switch(ageRestriction) 
		{
			case None : s = "Hàng cho mọi lứa tuổi" ; break;
			case Teenager : s = "Hàng cho tuổi teen" ; break;
			case Adult : s = "Hàng cho người lớn";break;
			default : s = "Nhập sai";break;
		}
		return "{Computer: " + System.lineSeparator()
				+ super.toString() + System.lineSeparator()
				+ "Price = " + this.getPrice() + System.lineSeparator() +
				 "Age restriction = " + s +" }"+ System.lineSeparator();
	}
	
}
