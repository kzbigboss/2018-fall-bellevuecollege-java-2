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
