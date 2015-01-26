package source;

import java.math.BigDecimal;
import java.math.RoundingMode;


/**
 * This class Utilizes the Object-Oriented Decorator Design pattern. 
 * 
 * By using the Decorator pattern, new taxes and multiple taxes can be
 * added on to any Item easily. This lets programmers create new taxes and
 * does not limit them to a single type of tax on an item. They can tax
 * the same Item multiple times thanks to the Item interface.
 * 
 * Implements the Item Interface which allows Taxes to be placed 
 * on Items. Taxes are 'wrapped' by the Decorator pattern.
 * 
 * This class is abstract which forces TaxDecorator child classes to add
 * a Tax Rate.
 * 
 * @author Javi Sanchez
 *
 */
public abstract class TaxDecorator implements Item{

	private Item item;
	
	protected double rate;
	
	public TaxDecorator(Item item){
		this.item = item;
	}
	
	/**
	 * Implements the Item method to return the price of an Item with all taxes applied to the Item
	 * 
	 * This method uses the overridden method getRate() of the child classes ImportTaxDecorator and 
	 * SalesTaxDecorator to add on the taxes to the Item price.
	 */
	public double getPrice(){
		double salesTax = roundTax(this.getRate() * this.item.getShelfPrice());
		return roundPrice(this.item.getPrice() + salesTax);
	}
	
	/**
	 * Helper Function to round the Tax.
	 */
    private double roundTax(double val){
		return new BigDecimal(Math.ceil(val * 20)/20).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}
    
    /**
     * Helper Function to round the Price.
     */
    private double roundPrice(double val){
    	return new BigDecimal(val).setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
    
    public abstract double getRate();

	@Override
	public abstract String getName();

	@Override 
	public abstract double getShelfPrice();
	
	@Override
	public abstract boolean isImported();
	
	@Override
	public abstract boolean isExempt();
    
}
