/*
Mark Kazzaz
test class
 */

public class Assignment7 {
    public static void main(String[] args) {

        //testProblem1();
        testProblem2();

    }

    public static void testProblem1() {
        // Testing Problem 1: upToNowTotal() running total method
        System.out.println("______START PROBLEM 1 TESTING______");
        System.out.println();

        /// create array for problem1a
        ArrayIntList problem1a = new ArrayIntList();

        /// add elements to problem1a array
        problem1a.add(2);
        problem1a.add(3);
        problem1a.add(5);
        problem1a.add(4);
        problem1a.add(7);
        problem1a.add(15);
        problem1a.add(20);
        problem1a.add(7);

        /// print to screen problem1a array
        System.out.print("Starting array: ");
        System.out.println(problem1a);

        /// manually print expected array
        /// TODO

        /// involve running total method via Problem 1
        ArrayIntList problem1b = ArrayIntList.upToNowTotal(problem1a);

        /// print to screen problem1a array
        System.out.print("Resulting array:");
        System.out.println(problem1b);

        /// double check that capacities match
        boolean matchingCapacities = problem1a.getCapacity() == problem1b.getCapacity();
        System.out.println("Capacities match: " + matchingCapacities);

        /// end of problem 1 testing
        System.out.println();
        System.out.println("______FINISH PROBLEM 1 TESTING______");
        System.out.println();
    }

    public static void testProblem2() {

//        ArrayIntList problem2Sorted = new ArrayIntList();
//        problem2Sorted.add(3);
//        problem2Sorted.add(8);
//        problem2Sorted.add(2);
//        problem2Sorted.add(5);
//        problem2Sorted.add(19);
//        problem2Sorted.add(24);
//        problem2Sorted.add(-3);
//        problem2Sorted.add(0);
//        problem2Sorted.add(4);
//        problem2Sorted.add(4);
//        problem2Sorted.add(8);
//        problem2Sorted.add(205);
//        problem2Sorted.add(42);
//
//        System.out.println(problem2Sorted);
//
//        System.out.println(ArrayIntList.isPairSorted(problem2Sorted));

        ArrayIntList problem2Unsorted = new ArrayIntList();
        problem2Unsorted.add(1);
        problem2Unsorted.add(9);
        problem2Unsorted.add(3);
        problem2Unsorted.add(17);
        problem2Unsorted.add(4);
        problem2Unsorted.add(28);
        problem2Unsorted.add(-5);
        problem2Unsorted.add(-3);
        problem2Unsorted.add(0);
        problem2Unsorted.add(42);
        problem2Unsorted.add(308);
        problem2Unsorted.add(409);
        problem2Unsorted.add(19);
        problem2Unsorted.add(17);
        problem2Unsorted.add(2);
        problem2Unsorted.add(4);

        System.out.println(problem2Unsorted);

        System.out.println(ArrayIntList.isPairSorted(problem2Unsorted));


    }

    public static void testProblem3() {

    }
}
