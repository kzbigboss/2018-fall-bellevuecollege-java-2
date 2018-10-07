/*
 * Mark Kazzaz, 2018-10-07
 * Bellevue College Fall 2018
 * Chapter 10 Assignment
 *
 */

// overall strategy: create new object to capture
// the relationship between item and quantity

public class ItemOrder {

    // fields
    private Item itemOrdered;
    private int quantityOrdered;

    public ItemOrder(Item itemInput, int quantityInput) {
        itemOrdered = itemInput;
        quantityOrdered = quantityInput;
    }

    // instance methods

    public double getPrice(){
        return itemOrdered.priceFor(quantityOrdered);
    }

    // accessors

    public Item getItem(){
        return itemOrdered;
    }
}
