// overall strategy: create an object that 'has a' ArrayList<Item>
// per instructions.

import java.util.*;

public class Catalog {
    // fields
    private String name;
    private ArrayList<Item> itemList = new ArrayList<Item>();

    // constructors
    public Catalog(String name){
        this.name = name;   // set the catalog's name
    }

    // accessors
    public String getName(){
        return name;
    }

    public int size(){
        return itemList.size();
    }

    public Item get(int index){
        return itemList.get(index);
    }

    // mutators
    public void add(Item inputItem){
        itemList.add(inputItem);
    }

}