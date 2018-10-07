/*
 * Mark Kazzaz, 2018-10-07
 * Bellevue College Fall 2018
 * Chapter 10 Assignment
 *
 */

// overall strategy: make an object to hold all the fields/methods
// necessary to meet Item requirements.  Leverage NumberFormat
// object to help with translating (double) price into (String) currency.

import java.text.*;

public class Item {

    // fields
    private String name;
    private double price;
    private int bulkQuantity;
    private double bulkPrice;
    private NumberFormat nf = NumberFormat.getCurrencyInstance();

    // constructors
    public Item (String name, double price){
        this(name, price, 0, 0);
    }

    public Item (String name, double price, int bulkQuantity, double bulkPrice){

        // throw error if any value is less than zero
        if (price < 0 || bulkPrice < 0 || bulkQuantity < 0){
            throw new IllegalArgumentException("Numerical values cannot be less than zero.");
        }

        // assign class values
        this.name = name;
        this.price = price;
        this.bulkQuantity = bulkQuantity;
        this.bulkPrice = bulkPrice;
    }

    // instance methods
    public double priceFor(int quantity){

        // throw error if value is less than zero
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
        }

        // if bulkQuantity isn't set, return qty * price
        // else run through logic to determine price by maximizing
        // bulk cost before individual cost

        if (bulkQuantity == 0){
            return quantity * price;
        } else {
            // Remove quantities covered by bulk prices
            int bulkInstance = quantity / bulkQuantity;
            quantity -= bulkInstance * bulkQuantity;

            // add together resulting bulk and individual costs
            return (bulkInstance * bulkPrice) + (quantity * price);

        }

    }

    public String toString(){

        // record start of string regardless of nonBulk v bulk
        //String result = name +", " + price;
        String result = name +", " + nf.format(price);

        // if bulk, append bulk pricing details
        if (bulkQuantity != 0){
            result += " (" + bulkQuantity + " for " + nf.format(bulkPrice) + ")";
        }

        return result;
    }

}
