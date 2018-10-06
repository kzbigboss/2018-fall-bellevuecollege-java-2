// overall strategy is to extend ArrayList<Item>
// and give the catalog an accessor to get its name.

import java.util.*;

public class Catalog extends ArrayList<Item> {
    // fields
    String name;

    // constructors
    public Catalog(String name){
        super();            // instantiate ArrayList<Item> object
        this.name = name;   // set the catalog's name
    }

    // accessors
    public String getName(){
        return name;
    }

}