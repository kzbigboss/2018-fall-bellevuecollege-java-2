import java.io.FileInputStream;
import java.util.*;

public class HuffmanNode { //TODO implements Comparable<HuffmanNode>

    // fields
    public int field;
    public char character;
    public HuffmanNode left;
    public HuffmanNode right;

    // isLeaf() to test whether or not this node is a leaf or branch. returns
    // true if leaf and false if branch.
    public boolean isLeaf() {
        return left != null && right != null;
    }

    public static Map<Character, Integer> getCounts(FileInputStream input) {
        Map<Character, Integer> charCounts = new TreeMap<Character, Integer>();

        try {
            while (input.available() != 0) {
                char value = (char) input.read();
                if (charCounts.containsKey(value)) {
                    int count = charCounts.get(value);
                    charCounts.put(value, count + 1);
                } else {
                    charCounts.put(value, 1);
                }
            }
            input.close();

        } catch (Exception e) {

            System.out.println(e);
        }

        return charCounts;
    }
}
