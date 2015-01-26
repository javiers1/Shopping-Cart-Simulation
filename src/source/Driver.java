package source;

import java.util.HashMap;
import java.util.Map;

/**
 * Driver to run and test the program. Items were constructed in the Driver,
 * 
 * Alternatively, a class to parse a text input could be constructed as well,
 * but the main focus of this in my opinion was the Object Oriented Design of the Classes and
 * Design of the Tax structure.
 * 
 * @author Javier Sanchez
 *
 */

public class Driver {

	public static final int TYPE_BOOK = 1;
	public static final int TYPE_MEDICAL = 2;
	public static final int TYPE_FOOD = 3;
    public static final int TYPE_OTHER = 4;

	public static void main(String[] args) {
		//Create the Shopping Cart Map
		Map<Item,Integer> cart = new HashMap<Item,Integer>();
		
		//Create Basic Items with designated properties
		Item book = new BasicItem("Book", 12.49, false, TYPE_BOOK);
		Item chocolate = new BasicItem("Chocolate Bar", 0.85, false, TYPE_FOOD);
		Item musicCD = new BasicItem("Music CD", 14.99, false, TYPE_OTHER);
		
		//Add to cart
		cart.put(book, 1);
		cart.put(chocolate, 1);
		cart.put(musicCD, 1);
		
		//Create the order and print input/receipt with taxes
		Order order1 = new Order(cart);
		order1.printOrderInput();
		order1.printOrderWithTaxes();
		
		//Clear the cart for the next input order
		cart.clear();
		
		//Input 2
		Item importChocolate = new BasicItem("Imported Chocolate Bar", 10.00, true, TYPE_FOOD);
		Item perfume = new BasicItem("Imported bottle of Perfume", 47.50, true, TYPE_OTHER);
		
		cart.put(importChocolate, 1);
		cart.put(perfume, 1);
		
		Order order2 = new Order(cart);
		order2.printOrderInput();
		order2.printOrderWithTaxes();
		
		cart.clear();
		
		//Input 3
		Item importPerfume = new BasicItem("Imported bottle of Perfume", 27.99, true, TYPE_OTHER);
		Item domesticPerfume = new BasicItem("Bottle of perfume", 18.99, false, TYPE_OTHER);
		Item pills = new BasicItem("Packet of Headache Pills", 9.75, false, TYPE_MEDICAL);
		Item importedChocolate = new BasicItem("Imported box of Chocolates", 11.25, true, TYPE_FOOD);
		
		cart.put(importPerfume,1);
		cart.put(domesticPerfume,1);
		cart.put(pills,1);
		cart.put(importedChocolate,1);
		
		Order order3 = new Order(cart);
		order3.printOrderInput();
		order3.printOrderWithTaxes();
		
		cart.clear();
		
	}

}
