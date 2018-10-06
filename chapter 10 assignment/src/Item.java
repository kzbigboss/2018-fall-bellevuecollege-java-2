public class Item {

    // fields
    String name;
    double price;
    int bulkQuantity;
    double bulkPrice;

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
        if (quantity < 0){
            throw new IllegalArgumentException("Quantity cannot be less than zero.");
        }

        // TODO solve when bulk quantity is zero; currently throwing an error when div0

        // If no bulk quantity set, simply return quantity * price
        if (bulkQuantity == 0) return quantity * price;

        // determine how many bulk quantities are being purchased
        // then reduce quantity amount being fulfill via bulk quantities
        int bulkInstance = quantity / bulkQuantity;
        quantity -= bulkInstance * bulkQuantity;

        // return the price
        return  (quantity * price)              // individual quantities price
                    +
                (bulkInstance * bulkPrice);     // bulk quantities price

    }


}
