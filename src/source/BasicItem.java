package source;

/**
 * Basic Item implements the Item interface.
 * 
 * This extension of the Item interface carries simple properties such as
 * shelfPrice, price(with taxes), item type, exempt status, and import status.
 * 
 * @author Javier Sanchez
 *
 */
public class BasicItem implements Item{
    private String name;
    @SuppressWarnings("unused")
	private double price;
    private double shelfPrice;
    private int type;
	private boolean imported;
    private boolean exempt;
	
    /**
     * The minimum parameters needed for a Basic Item to be constructed
     * @param name - name of item
     * @param shelfPrice - price before taxes
     * @param imported - boolean if imported or not
     * @param type - Integer representing item type
     */
    public BasicItem(String name, double shelfPrice, boolean imported, int type) {
		this.name = name;
		this.shelfPrice = shelfPrice;
		this.imported = imported;
		this.type = type;
	}
    
	public String getName() {
		return name;
	}

	/**
	 * This method gets overridden by the Tax Decorator Pattern.
	 * The Overridden method will return a Price with all Taxes applied 
	 * to the price recursively.
	 */
	public double getPrice() {
		return shelfPrice;
	}


	public double getShelfPrice() {
		return shelfPrice;
	}


	public boolean isImported() {
		return imported;
	}
	
	public boolean isExempt(){
		return exempt;
	}
	
	public int getType() {
		return type;
	}

}
