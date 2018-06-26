package trade;

import java.time.LocalDate;

import interfaces.Expirable;
import model.AgeRestriction;
import model.Product;

public final class PurchaseManager {
	
	public PurchaseManager(){
		
	}

	public static void processPurchase(Product product, Customer customer ) {
		validatePurchase(product,customer);
	}

	private static void validatePurchase(Product product, Customer customer) {
		if(product.getQuantity() == 0) {
			System.out.println("This product is out of stock!");
		}
		if(hasExpired(product)) {
			System.out.println("This product is expired!");
		}
		if(!hasEnoughMoney(product,customer)) {
			System.out.println("You don't have enough money!");
		}
		if(isEnoughAge(product,customer)) {
			
		}
	}

	private static boolean isEnoughAge(Product product, Customer customer) {
		if(customer.getTuoi() >= 13 && product.getAgeRestriction() == AgeRestriction.Teenager) {
			return true;
		}
		else if(customer.getTuoi() >= 20 && product.getAgeRestriction() == AgeRestriction.Adult) {
			return true;
		}
		else if(product.getAgeRestriction() == AgeRestriction.None) {
			return false;
		}
		else 
		{
			return false;
		}
	}

	private static boolean hasEnoughMoney(Product product,Customer customer) {
		if(customer.getBalance() >= product.getPrice()) {
			return true;
		}
		return false;
	}

	private static boolean hasExpired(Product product) {
		if(product instanceof Expirable) {
			Expirable expirableProduct = (Expirable) product;
			if(expirableProduct.getExpirationDate().isBefore(LocalDate.now())) {
				return true;
			}
		}
		
		return false;
	}
	
}
