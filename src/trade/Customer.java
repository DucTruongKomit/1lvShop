package trade;

public class Customer {
	private String name;
	private int tuoi;
	private double balance;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTuoi() {
		return tuoi;
	}
	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Customer(String name, int tuoi, double balance) {
		super();
		this.name = name;
		this.tuoi = tuoi;
		this.balance = balance;
	}
	public Customer() {
		super();
	}
	
	
	
}
