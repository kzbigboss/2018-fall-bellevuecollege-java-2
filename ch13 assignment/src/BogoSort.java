/*
Mark Kazzaz - 2018-11-01
Bellevue College - Fall Quarter
CS211
 */

public class BogoSort {

    public static void main(String[] args) {

        int experimentIterations = 3;
        int experimentThrough = 100; // upper limit of array sizes to experiment through


        for (int i = 3; i <= experimentThrough; i++) {
            runExperiment(i, experimentIterations);
        }

    }

    public static void runExperiment(int arraySize, int experimentIterations) {
        // build and populate array
        for (int exp = 0; exp < experimentIterations; exp++) {
            int[] myArray = new int[arraySize];

            for (int i = 0; i < arraySize; i++) {
                int random = (int) (Math.random() * 10000) + 10; // adding 10 to avoid any chance of single digits
                myArray[i] = random;
            }


            // run experiment
            long start = System.currentTimeMillis();
            System.out.println("Array size of " + arraySize + " iteration " + exp + " + started at " + start);
            //printArray(myArray);
            bogoSort(myArray);
            long end = System.currentTimeMillis();
            System.out.println("Array size of " + arraySize + " iteration " + exp + " + ended at " + end);
            System.out.println("Array size of " + arraySize + " iteration " + exp + " + duration was " + (end - start));
            //printArray(myArray);
            System.out.println();
        }
    }


    // Places the elements of a into sorted order.
    public static void bogoSort(int[] a) {
        // MK: while isSorted is false, keep shuffling the array

        while (!isSorted(a)) {
            shuffle(a);
        }

    }

    // Returns true if a's elements are in sorted order.
    public static boolean isSorted(int[] a) {
        // MK: traverse through the array checking the values
        // at i and i+1.  if i+1 is greater than i, return false.
        // if it passes through the list without i+1 > i, return true.

        for (int i = 0; i < a.length - 1; i++) {
            if (a[i] > a[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // Shuffles an array of ints by randomly swapping each
    // element with an element ahead of it in the array.
    public static void shuffle(int[] a) {
        // MK: leverage Math.random to find a number between 0 and 1.
        // Treat Math.random as a percentage, multiply it against the
        // number of items in the list.  Leverage integer division to
        // end up with a integer between 0 and array length.
        // Repeat that twice to end up with two random indices.
        // Swap the values for the two random indices.

        int i1 = (int) (Math.random() * a.length);
        int i2 = (int) (Math.random() * a.length);

        swap(a, i1, i2);
    }

    // Swaps a[i] with a[j].
    public static void swap(int[] a, int i, int j) {

        // MK: Swap the values of the provided indices
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);

        }
    }

}
//end of BogoSort class