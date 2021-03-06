package source;

/**
 * Extends the TaxDecorator to represent a Sales Tax.
 * 
 * This child class adds a 10% tax rate to the shelfPrice of the item
 * it 'Decorates'.
 * 
 * @author Javier Sanchez
 *
 */
public class SalesTaxDecorator extends TaxDecorator {
	
	private Item item;
	
	private final double rate = 0.1;
	
	public SalesTaxDecorator(Item item) {
		super(item);
		this.item = item;
	}
	
	/**
	 * Override the getRate method to return the tax rate for an item that is not exempt
	 * from sales tax.
	 * 
	 * Used by the TaxDecorator superclass to calculate and add the tax to the
	 * item shelfPrice any time the getPrice() method is called.
	 * 
	 * @return the tax rate of the imported item
	 */
	public double getRate(){
		return this.rate;
	}

	@Override
	public String getName() {
		return item.getName();
	}

	@Override
	public double getShelfPrice() {
		return item.getShelfPrice();
	}

	@Override
	public boolean isImported() {
		return item.isImported();
	}

	@Override
	public boolean isExempt() {
		return item.isExempt();
	}
	
	@Override
	public int hashCode() {
		return this.getName().hashCode();
	}

	@Override
	public int getType() {
		return item.getType();
	}

}