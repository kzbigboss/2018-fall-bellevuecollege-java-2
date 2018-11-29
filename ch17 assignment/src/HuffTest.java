import java.io.FileInputStream;
import java.util.*;

public class HuffTest {

    public static void main(String[] a) {
        try{
            Map<Character, Integer> counts = HuffmanNode.getCounts(new FileInputStream("/Users/kazzazmk/Repos/2018-fall-bellevuecollege-java-2/ch17 assignment/test.txt"));
            System.out.println(counts);
        }catch(Exception e){System.out.println(e);}

    }
}
