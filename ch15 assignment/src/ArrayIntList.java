/*
Mark Kazzaz
2018-11-16
Bellevue College
CS211
Fall Quarter

Chapter 15: Assignment 7
Source Class
 */

import java.util.*;

// Class ArrayIntList can be used to store a list of integers.
public class ArrayIntList implements Iterable<Integer> {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the list

    public static final int DEFAULT_CAPACITY = 10;

    // post: constructs an empty list of default capacity
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }

    // pre : capacity >= 0
    // post: constructs an empty list with the given capacity
    private ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }

    // for creating test cases more easily
    public ArrayIntList(int... elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.length * 2));
        for (int n : elements) {
            add(n);
        }
    }

    // for creating test cases more easily
    public ArrayIntList(int element, boolean notCapacity) {
        this();
        add(element);
    }

    // for creating test cases more easily
    public ArrayIntList(Collection<Integer> elements) {
        this(Math.max(DEFAULT_CAPACITY, elements.size() * 2));
        for (int n : elements) {
            add(n);
        }
    }

    // copy constructor; for creating test cases more easily
    public ArrayIntList(ArrayIntList list) {
        this(Math.max(DEFAULT_CAPACITY, list.size() * 2));
        addAll(list);
    }

    // pre : size() < capacity (elementData.length)
    // post: appends the given value to the end of the list
    public void add(int value) {
        add(size, value);
    }

    // pre: size() < capacity (elementData.length) && 0 <= index <= size()
    // post: inserts the given value at the given index, shifting subsequent
    //     values right
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        ensureCapacity(size + 1);

        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }

    // post: appends all values in the given list to the end of this list
    public void addAll(ArrayIntList other) {
        for (int i = 0; i < other.size; i++) {
            add(other.elementData[i]);
        }
    }

    // post: list is empty
    public void clear() {
        size = 0;
    }

    // post: returns true if the given value is contained in the list, false otherwise
    public boolean contains(int value) {
        return indexOf(value) != -1;
    }

    // post: ensures that the underlying array has the given capacity; if not,
    // the size is doubled (or more if given capacity is even larger)
    public void ensureCapacity(int capacity) {
        if (capacity > elementData.length) {
            int newCapacity = elementData.length * 2 + 1;
            if (capacity > newCapacity) {
                newCapacity = capacity;
            }
            int[] newList = new int[newCapacity];
            for (int i = 0; i < size; i++) {
                newList[i] = elementData[i];
            }
            elementData = newList;
        }
    }

    // returns true if o is an ArrayIntList with the same size and elements as this one
    public boolean equals(Object o) {
        if (!(o instanceof ArrayIntList)) {
            return false;
        }

        ArrayIntList other = (ArrayIntList) o;
        if (this.size != other.size) {
            return false;
        }

        for (int i = 0; i < size; i++) {
            if (elementData[i] != other.elementData[i]) {
                return false;
            }
        }

        return true;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }

    // post: returns capacity of this list's underlying array
    public int getCapacity() {
        return elementData.length;
    }

    // post : returns the position of the first occurence of the given
    //      value (-1 if not found)
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // post: returns true if list is empty, false otherwise
    public boolean isEmpty() {
        return size == 0;
    }

    // post: returns an iterator for this list
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator(this);
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index, shifting subsequent values left
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }

    // post: removes all occurrences of the values in the given list from this list
    public void removeAll(ArrayIntList other) {
        int newSize = 0;
        for (int i = 0; i < size; i++) {
            if (!other.contains(elementData[i])) {
                elementData[newSize] = elementData[i];
                newSize++;
            }
            size = newSize;
        }
    }

    // pre : 0 <= index < size()
    // post: replaces the integer at the given index with the given value
    public void set(int index, int value) {
        checkIndex(index);
        elementData[index] = value;
    }

    // post: returns the current number of elements in the list
    public int size() {
        return size;
    }

    // post: returns an array version of the contents of this list
    public int[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < elementData.length) {
                result += elementData[i];
            } else {
                // student's code is bogus; OOB
                result += "OOB!";
            }
        }
        result += "]";
        return result;
    }

    // helpers to make sure indexes do not fall out of bounds
    private void checkIndex(int index) {
        checkIndex(index, 0, size - 1);
    }

    private void checkIndex(int index, int min, int max) {
        if (!(min <= index && index <= max)) {
            throw new ArrayIndexOutOfBoundsException("Illegal index " + index +
                    "; must be between " + min + " and " + max + "\n"
                    + "list : " + toString() + " (size=" + size + ")\n"
                    + "array: " + Arrays.toString(elementData) + " (capacity=" + elementData.length + ")");
        }
    }


    // Stuart Reges
    // 4/4/05
    //
    // The ArrayIntListIterator class provides a set of utilities for iterating
    // over an ArrayIntList and possibly removing values from the list.

    private static class ArrayIntListIterator implements Iterator<Integer> {
        private ArrayIntList list;    // list to iterate over
        private int position;          // current position within the list
        private boolean removeOK;      // whether it's okay to remove now

        // pre : list != null
        // post: constructs an iterator for the given list
        public ArrayIntListIterator(ArrayIntList list) {
            this.list = list;
            position = 0;
            removeOK = false;
        }

        // post: returns true if there are more elements left, false otherwise
        public boolean hasNext() {
            return position < list.size();
        }

        // pre : hasNext()
        // post: returns the next element in the iteration
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int result = list.get(position);
            position++;
            removeOK = true;
            return result;
        }

        // pre : next() has been called without a call on remove (i.e., at most one
        //     call per call on next)
        // post: removes the last element returned by the iterator
        public void remove() {
            if (!removeOK)
                throw new IllegalStateException();
            list.remove(position - 1);
            position--;
            removeOK = false;
        }
    }

    // start of code written by Mark Kazzaz

    // requirement 1: instance method called uptoNowTotal() that returns a
    // new ArrayIntList containing a running total of the input list

    // post:    returns a newly constructed ArrayIntList reflecting a
    //          running total of the list this method is called on.
    //          &&
    //          newly created ArrayIntList has the same capacity of source list.

//    public static ArrayIntList upToNowTotal11(ArrayIntList input) {
//
//        // create new ArrayIntList with same capacity as input list
//        ArrayIntList result = new ArrayIntList(input.getCapacity());
//
//        // evaluate if size is < 0
//        if (input.size() < 0) {
//            // if true, return empty list
//            return result;
//        } else {
//            // if false, proceed with method
//
//            // fencepost loop through the input list while
//            // adding the previous result list and the current input
//            // list element values together
//
//            /// fencepost
//            result.add(input.get(0));
//
//            /// current input element + prior result element
//            for (int i = 1; i < input.size(); i++) { // loop 1 thru N
//                result.add(input.get(i) + result.get(i - 1));
//            }
//
//            return result;
//        }
//
//    }

    public ArrayIntList upToNowTotal() {
        // create new ArrayIntList with same capacity as source list
        ArrayIntList result = new ArrayIntList(this.getCapacity());

        // evaluate if size is <= 0
        if (this.size <= 0) {
            // if true, return empty list
            return result;
        } else {
            // if false, proceed with create new running total list

            // fencepost (get initial value) then loop to add current value
            // to preceeding value

            result.add(elementData[0]);

            for (int i = 1; i < size; i++) {
                result.add(elementData[i] + result.get(i - 1));
            }

            return result;
        }
    }


    // requirement 2: method called isPairSorted() that returns a boolean
    // indicating if the pairs in a ArrayIntList are in sorted order. if a
    // list contains an odd number of elements, ignore the final element. if a
    // list contains zero elements, report true.

    // post:    function steps through the pairs of elements in the input list
    //          and reports true/false based on whether the pairs are sorted.

//    public static boolean isPairSorted(ArrayIntList input) {
//
//        // we can use a for loop based on half the size of the list size.  This
//        // will help us compare pairs as well as ignore the final element in
//        // odd sized lists.
//
//        for (int i = 0; i < input.size() / 2; i++) {
//            // leverage multiplication and figure out if all pairs are ordered.
//            // if not, return false
//            int firstHalf = input.get(i * 2);
//            int secondHalf = input.get(i * 2 + 1);
//            if (firstHalf > secondHalf) {
//                return false;
//            }
//
//        }
//
//        // if we traverse the list without setting off the if statement above,
//        // then return true
//        return true;
//    }


    //post: return true/false after evaluating if list's ordered pairs are sorted
    public boolean isPairSorted(){
        for (int i = 0; i < size / 2; i++){
            //TODO COMMMENTS
            int firstHalf = elementData[i * 2];
            int secondHalf = elementData[i * 2 + 1];
            if (firstHalf > secondHalf){
                return false;
            }
        }

        //TODO COMMENTS
        return true;
    }

    // requirement 3: method called removeLast() that takes int n as a parameter
    // and removed the first n values from a list of integers


    public void removeLast(int n){
        size = size - n;
    }

}
