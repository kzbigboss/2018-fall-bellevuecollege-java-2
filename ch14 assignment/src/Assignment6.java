/*
Mark Kazzaz
2018-11-09
Bellevue College, CS211, Fall Quarter
 */

import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Assignment6 {


    public static void main(String[] args) {
//        testSeeingThreeMethod();
        testTwoStacksAreEqualMethod();
//        testIsMirrored();

    }

    public static void seeingThree(Stack<Integer> s) {
        Stack<Integer> helper = new Stack<Integer>(); // helper stack

        // pop source stack into helper stack
        while (!s.isEmpty()) {
            helper.push(s.pop());
        }

        // pop back into source in triples
        while (!helper.isEmpty()) {
            int n = helper.pop();
            for (int i = 0; i < 3; i++) {
                s.push(n);
            }
        }
    }


    public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {

        boolean result = true; // return result

        Stack<Integer> helper = new Stack<Integer>(); // helper stack

        // if sizes are different, already know they're different
        if (s1.size() != s2.size()) {
            result = false;
        } else {
            // since sizes are the same, let's see if each pop is the same
            // only pop if both stacks aren't empty and we haven't yet set
            // the return variable to faslse
            while (!s1.isEmpty() && !s2.isEmpty() && result) {
                int n = s1.pop(); // pop from s1
                int m = s2.pop(); // pop from s2

                if (n != m) { // if different, set false
                    result = false;
                }

                // populate helper stack
                helper.push(n);
                helper.push(m);
            }
        }

        // unload helper, restore original stacks
        // since we're using isEmpty(), this only occurs if
        // we actually made it far enough to populate the stack
        while (!helper.isEmpty()) {
            s2.push(helper.pop());
            s1.push(helper.pop());
        }

        return result; // bingo lingo here-we-go

    }

    public static boolean isMirrored(Queue<Integer> q) {
        // overall: populate stack with queue results so the queue
        // is in the original order but the stack is in the reversed
        // order.  then remove/pop the elements from each and compare. if
        // i trip on an element that doesn't match, alter the return
        // variable to false but continue to run to restore the queue
        // to where we started

        Stack<Integer> helper = new Stack<Integer>(); // helper stack

        boolean result = true; // return variable

        // circulate through queue to populate stack
        int size = q.size();

        for (int i = 0; i < size; i++){
            int n = q.remove();     // remove start of queue
            helper.push(n);         // push to stack
            q.add(n);               // add to end of queue
        }

        // circulate through queue, pop the stack, and compare each element.
        // if the element doesn't match then alter the return variable.

        for (int i = 0; i < size; i++){ // remove + pop
            int n = q.remove();
            int m = helper.pop();

            if (n != m){ // compare, if F then alter return variable
                result = false;
            }

            q.add(n); // add to end of queue
        }

        return result;

    }


    private static void testIsMirrored() {

        Queue<Integer> myQueueP = new LinkedList<Integer>();

        for (int i = 0; i < 5; i++) {

            System.out.print(i);
            myQueueP.add(i);

        }
        for (int i = 3; i >= 0; i--) {

            System.out.print(i);
            myQueueP.add(i);

        }


        System.out.println();

        System.out.println(isMirrored(myQueueP) + " isMirrored");

    }


    private static void testTwoStacksAreEqualMethod() {
        Stack<Integer> myStack1 = new Stack<Integer>();
        Stack<Integer> myStack2 = new Stack<Integer>();
        Stack<Integer> myStack3 = new Stack<Integer>();
        Stack<Integer> myStack4 = new Stack<Integer>();

        for (int i = 0; i < 5; i++) {
            myStack1.push(i);
            myStack2.push(i);
            myStack4.push(i);

        }
        for (int i = 0; i < 6; i++) {
            myStack3.push(i);

        }

        System.out.println(twoStacksAreEqual(myStack1, myStack2) + " Same Stack ");

        System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");

    }


    private static void testSeeingThreeMethod() {
        Stack<Integer> myStack = new Stack<Integer>();

        for (int i = 0; i < 5; i++) {
            myStack.push(i);

        }


        System.out.println();
        print(myStack);

        seeingThree(myStack);

        print(myStack);

    }

    private static void print(Stack<Integer> s) {
        Enumeration<Integer> e = s.elements();

        while (e.hasMoreElements())
            System.out.print(e.nextElement() + " ");
        System.out.println();


    }

} //end of Assignment6 
