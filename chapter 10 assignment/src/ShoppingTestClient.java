public class ShoppingTestClient {

    public static void main(String[] args){
        // Example item
        System.out.println("Create example item");
        Item example = new Item("blahrah", 0.99);

        // test get price
        System.out.println(example.priceFor(100));
    }

}
