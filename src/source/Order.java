package source;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;

/**
 * The Order class acts as a container for Item objects.
 * 
 * Keeps an original order input,
 * then calculates a taxed order immediately with a TaxCalculator Object instance.
 * 
 * Performs an 'eager' calculation of Taxes as soon as the Order object is instantiated
 * with a Map of items.
 * 
 * By default, exempt types are hard coded into the constructor, but, can be passed in
 * via another constructor or set before taxes are calculated.
 * 
 * @author Javi
 *
 */
public class Order {
	private Map <Item,Integer> items;
    private Map<Item,Integer> taxedItems;
    private Set<Integer> exemptTypes;
    private TaxCalculator taxCalculator;
    private double total;
    private double taxTotal;
    
    static final public int TYPE_BOOK = 1;
    static final public int TYPE_MEDICAL = 2;
    static final public int TYPE_FOOD = 3;
    static final public int TYPE_OTHER = 4;
    
    /**
     * Constructor. Initialized with a Map of Items and Quantities
     * By default, exempt types are also constructed, but can be
     * easily modified by the setExempt types method.
     * @param items
     */
    public Order(Map<Item,Integer> items){
    	this.items = items;
    	this.exemptTypes = new HashSet<Integer>();
    	this.exemptTypes.add(TYPE_BOOK);
    	this.exemptTypes.add(TYPE_MEDICAL);
    	this.exemptTypes.add(TYPE_FOOD);
    	this.taxCalculator = new TaxCalculator(exemptTypes);
    	this.taxedItems = taxCalculator.calculateTaxes(items);
    }
	
    public Map<Item,Integer> getItems() {
		return items;
	}
	
    public void setItems(Map<Item,Integer> items) {
		this.items = items;
	}
	
    public Map<Item,Integer> getTaxedItems() {
		return taxedItems;
	}
	
    public double getTotal() {
		return total;
	}
	
    public double getTaxTotal() {
		return taxTotal;
	}
	
    /**
     * Re-sets the exemptTypes set to be considered when calculating taxes.
     * @param exemptTypes
     */
    public void setExemptTypes(Set<Integer> exemptTypes){
    	this.exemptTypes = exemptTypes;
    }
    
    /**
     * Calculates taxes of the current order and sets the taxedItems map.
     */
    public void calculateTaxes(){
    	taxedItems = taxCalculator.calculateTaxes(items);
    }
    
    /**
     * Prints the original order input in specified format.
     */
    public void printOrderInput(){
    	DecimalFormat df = new DecimalFormat("0.00"); 
    	System.out.println("Order Input: ");
    	for(Item item: items.keySet()){
    		System.out.println(items.get(item) + " " + item.getName() + " at " + df.format(item.getShelfPrice()));
    	}
    }
    
    /**
     * Prints the original order input with taxes calculated as well.
     */
    public void printOrderWithTaxes(){
    	total = 0;
    	taxTotal = 0;
    	DecimalFormat df = new DecimalFormat("0.00"); 
    	System.out.println();
    	System.out.println("Order Totals: ");
    	for(Item item: taxedItems.keySet()){
    		System.out.println(taxedItems.get(item) + " " + item.getName() + ": " + df.format(item.getPrice()));
    		total += item.getPrice();
    		taxTotal += (item.getPrice() - item.getShelfPrice());
    	}
    	System.out.println("Sales Tax: " + df.format(roundTax(taxTotal)));
    	System.out.println("Total: " + df.format(roundPrice(total)) + "\n");
    }
    
    /**
     * Helper Functions to Round up Prices and Taxes. 
     */
    private double roundTax(double val){
		return new BigDecimal(Math.ceil(val * 20)/20).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
    
    private double roundPrice(double val){
    	return new BigDecimal(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
}
