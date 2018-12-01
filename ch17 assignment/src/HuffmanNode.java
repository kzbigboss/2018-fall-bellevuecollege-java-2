import java.io.FileInputStream;
import java.util.*;

public class HuffmanNode implements Comparable<HuffmanNode> {

    // fields, OK that nodes to use public variables
    public char character;
    public int frequency;
    public HuffmanNode left;
    public HuffmanNode right;

    // constructor for new node without children
    public HuffmanNode(char character, int frequency){
        this.character = character;
        this.frequency = frequency;
        left = null;
        right = null;
    }

    // constructor for new node with children
    public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right){
        this.frequency = frequency;
        this.left = left;
        this.right = right;
    }

    // constructor for new node for count branch node
    public HuffmanNode(int frequency){
        this.frequency = frequency;
        left = null;
        right = null;
    }

    // isLeaf() to test whether or not this node is a leaf or branch. returns
    // true if leaf and false if branch.
    // post: true/false depending if node is leaf or not.
    public boolean isLeaf() {
        return left != null && right != null;
    }

    // static method to construct a mapping of characters and their count
    // in the input file.  special treatment is given when the EOF is reached;
    // the code manually insert the ASCII equivalent of EOF.
    // post: creates character mapping specific to input file.

    public static Map<Character, Integer> getCounts(FileInputStream input) {
        Map<Character, Integer> charCounts = new TreeMap<Character, Integer>();

        boolean keepRunning = true; // boolean to assist while loop

        try {
            //while (input.available() != 0) {
            while (keepRunning) {

                // read next byte into int
                int readInt = input.read();

                // if readInt == -1, insert EOF, else add to character map
                if (readInt == -1){
                    charCounts.put((char) 4, 1);    // input from ch18 discussion was to use ASCII 4 for EOF signal
                                                    // https://bc.instructure.com/courses/1626337/discussion_topics/8184595
                    keepRunning = false;
                } else {
                    char value = (char) readInt;
                    if (charCounts.containsKey(value)) {
                        int count = charCounts.get(value);
                        charCounts.put(value, count + 1);
                    } else {
                        charCounts.put(value, 1);
                    }
                }


            }
            input.close();

        } catch (Exception e) {

            System.out.println(e);
        }

        return charCounts;
    }

    // enables Comparable interface by providing a way to compare one node
    // to another.
    // post: returns the delta of this node against the other node.
    public int compareTo(HuffmanNode other){
        return this.frequency - other.frequency;
    }
}
