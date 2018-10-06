// overall strategy: leverage a 'has a' ArrayList<E> (per requirements)
// to satisfy Shopping Cart requirements.  Use methods to traverse the
// shopping cart to calculate totals.  Remove items if they're already
// present in the cart when subsequent adds are performed.

import java.util.ArrayList;

public class ShoppingCart {

    // fields
    private ArrayList<ItemOrder> listShoppingCart = new ArrayList<ItemOrder>(); // empty cart
    private boolean discountApplied; // discount defaults to false

    public void add(ItemOrder inputItemOrder){

        int repeatIndex = -1;   // setup an index to figure out if the item is already in the cart

        for (ItemOrder captured : listShoppingCart){    // scan through the cart
            if (captured.getItem().equals(inputItemOrder.getItem())){   // determine if the cart already has the item
                repeatIndex = listShoppingCart.indexOf(captured);       // if it does, update the index
            }
        }

        if (repeatIndex != -1){
            // if the index was updated then drop and add the item
            listShoppingCart.remove(repeatIndex);
            listShoppingCart.add(inputItemOrder);
        } else {
            // if the index wasn't updated, add the item
            listShoppingCart.add(inputItemOrder);
        }
    }

    // instance methods
    public double getTotal(){
        // variable to capture running total
        double totalPrice = 0;

        // for each loop through the shopping card
        for (ItemOrder itemAdded : listShoppingCart){
            // add individual ItemOrder to running total
            totalPrice += itemAdded.getPrice();
        }

        // return total price
        if (discountApplied){
            // discount applied? then apply 10% discount
            return totalPrice * .9;
        } else {
            // discount not applied?  return total amount without adjustment
            return totalPrice;
        }
    }

    // mutators

    // set discount on or off based on boolean parameter
    public void setDiscount(boolean inputDiscount){
        discountApplied = inputDiscount;
    }

}
