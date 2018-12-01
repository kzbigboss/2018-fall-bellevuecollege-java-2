import java.util.*;
import java.io.InputStream;


public class HuffmanTree {

    // define fields
    Map<Character, Integer> charCounts; // character mapping from HuffmanNode
    private HuffmanNode overallRoot;    // root of our HuffmanTree
    Queue<HuffmanNode> priorityQueue;   // priority quote to help with node order

    // constructors
    public HuffmanTree(Map<Character, Integer> charCounts) {
        this.charCounts = charCounts;       // store mapping
        this.priorityQueue = buildPQueue(); // build prioritiy queue of nodes
        buildHuffmanTree();                 // build Huffman algo tree

    }

    // mutators


    // traverse through character mapping and build a priority queue so that
    // nodes are in order prior to building tree
    // post: priority queue of nodes
    private PriorityQueue<HuffmanNode> buildPQueue() {

        PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>();

        // add nodes from input charCounts to queue.
        // building new nodes so they persist after the method ends.
        // post: priority queue of HuffmanNodes
        for (Map.Entry<Character, Integer> mapping : charCounts.entrySet()) {
            priorityQueue.add(new HuffmanNode(mapping.getKey(), mapping.getValue()));
        }

        return priorityQueue;
    }

    // build a Huffmann algorithm tree by traversing the priority queue of nodes
    private void buildHuffmanTree() {

        // loop until the queue only has one entry representing the root
        while (priorityQueue.size() > 1) {
            // load two loadest value nodes and create a parent for them
            HuffmanNode left = this.priorityQueue.remove();
            HuffmanNode right = this.priorityQueue.remove();
            int parentValue = left.frequency + right.frequency;
            HuffmanNode parent = new HuffmanNode(parentValue, left, right);

            // add new node back to queue
            priorityQueue.add(parent);
        }

        // make the root node the first node present in the queue
        this.overallRoot = priorityQueue.remove();

    }

    // compress an input file to prepare for Huffman algo treatment
    // per instructions, use StringBuilder in place of String
    public StringBuilder compress(InputStream inputFile) {
        int readValue = 0;
        StringBuilder result = new StringBuilder();

        try {
            while((readValue = inputFile.read()) != -1){
                result.append(makeRoute(readValue, overallRoot, ""));

            }
        } catch (Exception e) {

            System.out.println(e);
        }

        return result;
    }

    // accessors

    // client facing method for printing tree
    public String printSideways() {
        return printSideways(overallRoot, 0); // calling private method with tab index
    }

    // internal method for printing tree with starting node & tabbing index
    private String printSideways(HuffmanNode start, int index) {
        String result = "";

        if (start != null) {
            result += printSideways(start.right, index + 1);
            for (int i = 0; i < index; i++) {
                result += "     ";
            }
            if (start.character == '\0') {      // empty character
                result += start.frequency + "=frequency";
            } else {
                result += start.frequency + "=character(" + (int) start.character + ") " + start.character;
            }
            result += "\n\n";                   // new lines for ease of printing
            result += printSideways(start.left, index + 1);
        }

        return result;
    }

    // find out what route it takes to build the algorithm
    private String makeRoute(int code, HuffmanNode root, String path) {
        String result;
        if (root.isLeaf()) {
            result = ((char) code == root.character) ? path : null;
        } else {
            if ((result = makeRoute(code, root.left, path + '0')) == null) {
                result = makeRoute(code, root.right, path + '1');
            }
        }
        return result;
    }
}
