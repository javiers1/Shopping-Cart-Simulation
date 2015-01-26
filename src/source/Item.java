package source;
/**
 * Interface for an Item object.
 * 
 * Classes Extending this Interface:
 * BasicItem
 * TaxDecorator
 * 
 * Provides an Interface for Item classes so that the Tax Decorator
 * class can implement and override Items in order to pin taxes onto Item prices.
 * 
 * This Interface allows multiple kinds of Items to be created while maintaining the
 * functionality of decorating the Item with a Tax by the TaxDecorator.
 * (i.e. BasicItem (Implemented), ComplexItem, BulkItem, UsedVehicleItem, etc.)
 * All the examples above can extend the Item interface and be able to add Taxes.
 * 
 * @author Javier Sanchez
 *
 */
public interface Item {
    String getName();
    
    double getPrice();
    
    double getShelfPrice();
    
    int getType();
    
    boolean isImported();
    
    boolean isExempt();
}
