// overall strategy: leverage a 'has a' ArrayList<E> (per requirements)
// to satisfy Shopping Cart requirements.  Use methods to traverse the
// shopping cart to calculate totals.  Remove items if they're already
// present in the cart when subsequent adds are performed.

import java.util.ArrayList;

public class ShoppingCart {

    // fields
    private ArrayList<ItemOrder> listShoppingCart = new ArrayList<ItemOrder>(); // empty cart
    private boolean discountApplied; // distcount defaults to false

    public void add(ItemOrder inputItemOrder){
        // TODO Check list and drop if item already exists

        listShoppingCart.add(inputItemOrder);
    }

    // instance methods
    public double getTotal(){
        double totalPrice = 0; // variable to capture running total

        // for each loop through the shopping card
        for (ItemOrder itemAdded : listShoppingCart){
            totalPrice += itemAdded.getPrice(); // add individual ItemOrder to running total
        }

        // return total price
        if (discountApplied){   // discount applied? then apply 10% discount
            return totalPrice * .9;
        } else {
            return totalPrice;  // discount not applied?  return total amount without adjustment
        }
    }

    // mutators

    // set discount on or off based on boolean parameter
    public void setDiscount(boolean inputDiscount){
        discountApplied = inputDiscount;
    }

}
