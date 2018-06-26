package model;

public abstract class ElectionsProduct extends Product {
	protected int guaranteePeriodMonth;
	
	
	@Override
	public abstract double getPrice();

	public ElectionsProduct(String name,double price,int quantity,AgeRestriction ageRestriction,int guaranteePeriod) {
        super(name, price, quantity, ageRestriction);
        this.setGuaranteePeriodMonth(guaranteePeriod);
    }

	public int getGuaranteePeriodMonth() {
		return guaranteePeriodMonth;
	}

	public void setGuaranteePeriodMonth(int guaranteePeriodMonth) {
		this.guaranteePeriodMonth = guaranteePeriodMonth;
	}
	
	
}
