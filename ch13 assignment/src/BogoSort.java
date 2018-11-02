/*
Mark Kazzaz, 2018-11-01
Bellevue College, Fall Quarter, CS211
 */

/*
Analysis Results:
My background is in data science and analytics, so I took the liberty to
modify this main() to iterate through a number of experiments and dump the
results to the console.  I attempted to test array sizes of 0 through 100;
however, my machine wouldn't get passed N = 13 in a reasonable amount of
time.  My dataset ended up with 25 iterations of N = 0 through 12 and 12
iterations of N = 13.

My results and charts are captured in the related Excel file.  Clearly, this
algorithm was worsening at an incredible rate as N increases.  To determine
which order of N this algorithm represents, I charted it against O(N^2),
O(N^N), and O(N!).  O(N^2) and O(N^N) are two of the worst performing from
our textbook.  I thought of O(N!) (factorial) because this problem represents a
permutations challenge.  Each time the array is shuffled, we're actually
ending up with one of the N! permutations available.  I shared my Time
Observations and the BigO curves on separate axes so I could study the shape
of the curves which allows the chart to avoid being influenced by the magnitude
of the numbers.

O(N^2) clearly doesn't represent my observations as my observations don't
align to an quadratic curve.  O(N^N) is a tempting choice but N = 0 through
10 really don't align well.  O(N!) ends up with the best fitting curve: super
low values for N = 0 through 10 and incredible increasing values N = 11+.

Does this mean O(N!) is the best order of N that describes this algorithm?
Frankly, I'm not sure it does. While it represents the best possible curve,
we need to consider how the algorithm is constructed.  It is true that
each shuffle represents a distinct permutation of N elements in the array,
but the algorithm isn't tracking which permutations have been previously
considered.  This leaves the potential that the algorithm will cycle through
greater than N! permutations until the one where all elements are in a sorted
order is discovered.

As such, I believe the best possible order of N that represents this
algorithm is between O(N!) and O(Infinity).  The upper limit of O(Infinity)
considers the times that the algorithm shuffles more than N! when searching
for the permutation that is in sorted order.
 */

import java.util.Random;

public class BogoSort {

    public static void main(String[] args) {

        // experiment settings
        int experimentThrough = 100;    // upper limit of array sizes to experiment through
        int experimentIterations = 25;  // number of iterations for each size array

        // experiment run through
        for (int i = 13; i <= experimentThrough; i++) {
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
            printArray(myArray);
            bogoSort(myArray);
            long end = System.currentTimeMillis();
            System.out.println("Array size of " + arraySize + " iteration " + exp + " + ended at " + end);
            System.out.println("Array size of " + arraySize + " iteration " + exp + " + duration was " + (end - start));
            printArray(myArray);
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
        // MK: Using Random object to declare a random index
        // between i and the length of the array.  Swap the values
        // of i and the random index.

        Random r = new Random();

        for (int i = 0; i < a.length; i++){
            int j = r.nextInt(a.length - i) + i;
            swap(a, i, j);
        }
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
            //System.out.println(a[i]);
            System.out.print(a[i] + " "); //mk added

        }
        System.out.println(); // mk added
    }

}
//end of BogoSort class