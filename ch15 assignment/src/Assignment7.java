/*
Mark Kazzaz
2018-11-16
Bellevue College
CS211
Fall Quarter

Chapter 15: Assignment 7
Test main()
 */

public class Assignment7 {
    public static void main(String[] args) {

        testProblem1();
        testProblem2();
        testProblem3();

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

        /// involve running total method via Problem 1
        ArrayIntList problem1b = problem1a.upToNowTotal();

        /// print to screen problem1b array
        System.out.print("Resulting array:");
        System.out.println(problem1b);

        /// print to screen problem1a array to confirm it didn't change
        System.out.print("Original array: ");
        System.out.println(problem1a);

        /// double check that capacities match
        boolean matchingCapacities = problem1a.getCapacity() == problem1b.getCapacity();
        System.out.println("Capacities match: " + matchingCapacities);

        /// test empty array
        ArrayIntList problem1aEmpty = new ArrayIntList();
        System.out.print("Starting empty array: ");
        System.out.println(problem1aEmpty);

        ArrayIntList problem1bEmpty = problem1aEmpty.upToNowTotal();
        System.out.print("Resulting empty array: ");
        System.out.println(problem1bEmpty);

        System.out.print("Original empty array: ");
        System.out.println(problem1aEmpty);

        /// double check that capacities match for empty arrays
        boolean matchingCapacitiesEmpty = problem1aEmpty.getCapacity() == problem1bEmpty.getCapacity();
        System.out.println("Capacities match for empty arrays: " + matchingCapacitiesEmpty);

        /// end of problem 1 testing
        System.out.println();
        System.out.println("______FINISH PROBLEM 1 TESTING______");
        System.out.println();

    }

    public static void testProblem2() {
        System.out.println("______START PROBLEM 2 TESTING______");
        System.out.println();

        System.out.println("Known sorted pairs, expecting true:");
        ArrayIntList problem2Sorted = new ArrayIntList();
        problem2Sorted.add(3);
        problem2Sorted.add(8);
        problem2Sorted.add(2);
        problem2Sorted.add(5);
        problem2Sorted.add(19);
        problem2Sorted.add(24);
        problem2Sorted.add(-3);
        problem2Sorted.add(0);
        problem2Sorted.add(4);
        problem2Sorted.add(4);
        problem2Sorted.add(8);
        problem2Sorted.add(205);
        problem2Sorted.add(42);

        System.out.println(problem2Sorted);

        System.out.println("Pair sorted: " + problem2Sorted.isPairSorted());
        System.out.println();

        System.out.println("Known unsorted pairs, expecting false:");
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

        System.out.println("Pair sorted: " + problem2Unsorted.isPairSorted());
        System.out.println();

        System.out.println("Known single element list, expecting true due to odd zero:");
        ArrayIntList problem2One = new ArrayIntList();
        problem2One.add(1);
        System.out.println(problem2One);
        System.out.println("Pair sorted: " + problem2One.isPairSorted());
        System.out.println();

        System.out.println("Known zero element list, expecting true due to zero pairs:");
        ArrayIntList problem2Zero = new ArrayIntList();
        System.out.println(problem2Zero);
        System.out.println("Pair sorted: " + problem2Zero.isPairSorted());
        System.out.println();

        System.out.println();
        System.out.println("______FINISH PROBLEM 2 TESTING______");
        System.out.println();


    }

    public static void testProblem3() {
        /// create array for problem3a

        System.out.println("______START PROBLEM 3 TESTING______");
        System.out.println();

        ArrayIntList problem3a = new ArrayIntList();

        problem3a.add(8);
        problem3a.add(17);
        problem3a.add(9);
        problem3a.add(24);
        problem3a.add(42);
        problem3a.add(3);
        problem3a.add(8);

        System.out.println("Starting array: " + problem3a);

        problem3a.removeLast(0);

        System.out.println("With removeLast(0): " + problem3a);

        problem3a.removeLast(4);

        System.out.println("With removeLast(4): " + problem3a);

        problem3a.removeLast(problem3a.size());

        System.out.println("With removeLast(size): " + problem3a);

        System.out.println();
        System.out.println("______FINISH PROBLEM 3 TESTING______");
        System.out.println();

    }

//    public static void testProblem1Static() {
//        // WRONG - original built these methods as static methods
//        // Keeping original attempt to help build proper instance method testing
//
//        // Testing Problem 1: upToNowTotal() running total method
//        System.out.println("______START PROBLEM 1 TESTING______");
//        System.out.println();
//
//        /// create array for problem1a
//        ArrayIntList problem1a = new ArrayIntList();
//
//        /// add elements to problem1a array
//        problem1a.add(2);
//        problem1a.add(3);
//        problem1a.add(5);
//        problem1a.add(4);
//        problem1a.add(7);
//        problem1a.add(15);
//        problem1a.add(20);
//        problem1a.add(7);
//
//        /// print to screen problem1a array
//        System.out.print("Starting array: ");
//        System.out.println(problem1a);
//
//        /// involve running total method via Problem 1
//        ArrayIntList problem1b = ArrayIntList.upToNowTotal(problem1a);
//
//        /// print to screen problem1a array
//        System.out.print("Resulting array:");
//        System.out.println(problem1b);
//
//        /// double check that capacities match
//        boolean matchingCapacities = problem1a.getCapacity() == problem1b.getCapacity();
//        System.out.println("Capacities match: " + matchingCapacities);
//
//        /// end of problem 1 testing
//        System.out.println();
//        System.out.println("______FINISH PROBLEM 1 TESTING______");
//        System.out.println();
//    }

//    public static void testProblem2Static() {
//        // WRONG - original built these methods as static methods
//        // Keeping original attempt to help build proper instance method testing
//
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
//
//        ArrayIntList problem2Unsorted = new ArrayIntList();
//        problem2Unsorted.add(1);
//        problem2Unsorted.add(9);
//        problem2Unsorted.add(3);
//        problem2Unsorted.add(17);
//        problem2Unsorted.add(4);
//        problem2Unsorted.add(28);
//        problem2Unsorted.add(-5);
//        problem2Unsorted.add(-3);
//        problem2Unsorted.add(0);
//        problem2Unsorted.add(42);
//        problem2Unsorted.add(308);
//        problem2Unsorted.add(409);
//        problem2Unsorted.add(19);
//        problem2Unsorted.add(17);
//        problem2Unsorted.add(2);
//        problem2Unsorted.add(4);
//
//        System.out.println(problem2Unsorted);
//
//        System.out.println(ArrayIntList.isPairSorted(problem2Unsorted));
//
//
//    }


}
