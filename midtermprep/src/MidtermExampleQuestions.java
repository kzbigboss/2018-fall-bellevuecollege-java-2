import java.util.*;

public class MidtermExampleQuestions {

    // BC CS211 Midterm example Questions
    // Below is a working program. You should have sufficient experience
    // now to think like the computer, and know what output is produced:

    public static void main(String[] args) {
        Integer four = new Integer(4);
        Integer another = new Integer(4);
        Integer five = four;
        Integer six = new Integer(6);
        System.out.println(four == five); // 1-MK, this results in true as they're both
            // pointing to the same object.
        System.out.println(four != another); // 1.
            // comparing two objects, equality sign is asking if they're pointing to the
            // same object.  In this case, each object is a new Integer object.  So the
            // JVM will evaluate that case to be true (not equal).
        System.out.println(another.compareTo(four)); // 2.
            // This leverages the Comparable interface and determines if
            // a value is greater than, equal to, or less than
            // an object that it's being compared to.
        System.out.println(four.compareTo(six)); // 2-MK, sb less than, it is
        // Attached is a method that works on ArrayLists
        ArrayList<Integer> exam = new ArrayList<Integer>();
        System.out.println(exam.size() + 2); // 3.
        exam.clear();
        exam.add(3);
        exam.add(44);
        exam.add(555);
        mystery42(exam);

        System.out.println(exam); // 4.
        // Next we'll show understanding of Set operations:
        Set<Integer> object = new TreeSet<Integer>();
        mystery43(object);
        System.out.println(object); // 5.
        object.clear();
        object.add(11);
        object.add(2);
        mystery43(object);
        System.out.println(object); // 6.
        // And some operations on a Map:
        Map<Integer, String> thing = new TreeMap<Integer, String>();
        System.out.println(thing.size() - 1); // 7.
        thing.clear();
        thing.put(3, "11");
        thing.put(2, "22");
        thing.put(3, "22");
        System.out.println(thing);
        mystery44(thing);
        System.out.println(thing); // 8.
//        // Below are some recursive method calls, that are VERY similar to
//        // homework problems from our text:
        mystery3(3); // 9.
        System.out.println(); // blank place holder
        System.out.println();

    }

    // Follow the recursion problems:
    public static void mystery3(int n) {
        if (n < 0) {
            System.out.print("*");
        } else if (n % 3 == 0) {
            System.out.print("(");
            mystery3(n - 1);
            System.out.print(")");
        } else {
            System.out.print("[");
            mystery3(n - 1);
            System.out.print("]");
        }
    }

    // The comment before each method is the EXACT documentation you would find
    // in the Oracle online java API documentation
    // ArrayList questions:
    public static void mystery42(ArrayList<Integer> list) {
        for (int i = list.size() - 1; i > 0; i--) {
            // Returns the element at the specified position in this list.
            int a = list.get(i) + 1;
            // Replaces the element at the specified position in this list
            // with the specified element.
            list.set(i - 1, a);
        }
    }

    // Set questions:
    public static void mystery43(Set<Integer> set) {
        for (int i = set.size(); i > 0; i--) {
            // Removes the specified element from this set if it is present
            boolean a = set.remove(i);
            // Adds the specified element to this set if it is not already present
            set.add(i);
        }
    }

    // Map questions:
    public static void mystery44(Map<Integer, String> map) { // <Key,Value>
        for (int i = map.size() - 2; i > 0; i--) {

            // Removes the mapping for this key from this TreeMap if present.
            String a = map.remove(i);
            // Associates the specified value with the specified key in this map.
            map.put(i, a);
        }
    }
}