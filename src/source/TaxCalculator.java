package source;

import java.util.*;

/**
 * This Class takes a Set of exemptTypes and a Map of Items and Quantities
 * then adds TaxDecorator Taxes to the Item based on a property of the Item.
 * (In this case the Boolean variables isImported() and isExempt())
 * 
 * @author Javier Sanchez
 *
 */
public class TaxCalculator {
    public Set<Integer> exemptTypes;
    
	/**
	 * Constructor 
	 * @param exemptTypes - A set of Integers of Exempt items from Sales Tax
	 */
    public TaxCalculator(Set <Integer> exemptTypes){
		this.exemptTypes = exemptTypes;
	}
	
    /**
     * This method wraps Item objects in TaxDecorator object instances. Effectively adding 'Taxes'.
     * 
     * @param items - a Map of Items and Quantities on which Taxes will be applied
     * @return a Map of Items Decorated with TaxDecorator Objects and respective quantities.
     */
	public Map<Item,Integer> calculateTaxes(Map<Item,Integer> items){
    	Map<Item,Integer> taxedItems = new HashMap<Item,Integer>();
		int quantity = 0;

		for(Item item: items.keySet()){
			quantity = items.get(item);
			if(item.isImported()){
    			item = new ImportTaxDecorator(item);
    		}
    		if(!exemptTypes.contains(item.getType())){
    			item = new SalesTaxDecorator(item);
    		}
    		taxedItems.put(item, quantity);
    	}
		
		return taxedItems;
    }
}
