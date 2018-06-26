package test;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import interfaces.Expirable;
import model.AgeRestriction;
import model.Appliance;
import model.Computer;
import model.ElectionsProduct;
import model.FoodProduct;
import model.Product;
import trade.Customer;
import trade.PurchaseManager;

public class TestProduct {

	public static void main(String[] args) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String date1 = "07-02-2018";
		//LocalDate d1 = LocalDate.of(2018, Month.JUNE, 18,dtf);
		LocalDate d1 = LocalDate.parse(date1,dtf);
		 Customer pecata = new Customer("Pecata", 17, 30.00);
	     Customer gopeto = new Customer("Gopeto", 18, 0.44);
	     Customer pesho = new Customer("Pesho", 21, 50);
		
		FoodProduct f1 = new FoodProduct(LocalDate.now().plusDays(5));
		 FoodProduct expired = new FoodProduct(
	                "Noodle",
	                0.1,
	                20,
	                AgeRestriction.None,
	                LocalDate.now().minusDays(2));
		f1.setName("Banana");
		f1.setAgeRestriction(AgeRestriction.None);
		f1.setQuantity(100);
		f1.setPrice(10);
		System.out.println(f1);
		
		Product p1 = new Computer("Lenovo", 1200, 120, AgeRestriction.Teenager);
		Product p2 = new Appliance("Mouse", 19.99, 2500, AgeRestriction.None);
		Product p3 = new FoodProduct("soon", 10, 10, AgeRestriction.None, LocalDate.now().plusDays(18));
		Product p4 = new Computer("Asus", 2000, 1100, AgeRestriction.Adult);
		
		ArrayList<Product> arrProduct = new ArrayList<>();
		arrProduct.add(f1);arrProduct.add(p1);arrProduct.add(p2);
		arrProduct.add(p3);arrProduct.add(p4); arrProduct.add(expired);
		for(Product p : arrProduct) {
			System.out.println(p);
		}
		
		try {
            PurchaseManager.processPurchase(f1, pecata);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            PurchaseManager.processPurchase(f1, gopeto);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            PurchaseManager.processPurchase(f1, pesho);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        try {
            PurchaseManager.processPurchase(f1, pesho);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        try {
            PurchaseManager.processPurchase(expired, pesho);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
        // Checks all products, including expired ones
        System.out.println("The product which expires first is:");
        String expiresFirst = arrProduct.stream()
        		.filter(product -> product instanceof Expirable)
        		.map(product -> (Expirable) product)
        		.sorted((a1, a2) -> a1.getExpirationDate().compareTo(a2.getExpirationDate()))
        		.findFirst()
        		.map(product -> ((Product) product).getName()).get();
        
        System.out.println(expiresFirst);
        System.out.println();
        System.out.println("Adult products: ");
        List<Product> adultProducts = arrProduct
                .stream()
                .filter(product -> product.getAgeRestriction() == AgeRestriction.Adult)
                .sorted((a1, a2) -> Double.compare(a1.getPrice(), a2.getPrice()))
                .collect(Collectors.toList());

        for (Product adultProduct : adultProducts) {
            System.out.println(adultProduct.getName() + " - " + adultProduct.getPrice());
        }
        
	}

}
