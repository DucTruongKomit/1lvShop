package test;

import java.time.LocalDate;

import junit.framework.TestCase;
import model.AgeRestriction;
import model.FoodProduct;
import model.Product;

public class ProductTest extends TestCase {
	/*public ProductTest(double price){
		super();
	}*/
	
	public void testPrice() {
		Product p1 = new FoodProduct(
                "Noodle",
                0.1,
                20,
                AgeRestriction.None,
                LocalDate.now().minusDays(2));
		assertTrue(p1.checkPice());
	}
	
}
