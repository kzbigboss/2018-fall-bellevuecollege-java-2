import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

//Program 2 example

public class ArrayIntList implements Iterable<Integer> {
    private int[] elementData;  // list of integers
    private int size = 0;       // current number of elements in the list  
    public static final int DEFAULT_CAPACITY = 10;  
	public static void main(String[] args) {
		ArrayIntList a = new ArrayIntList(); 
		ArrayIntList b = new ArrayIntList(); 
		for(int i = 0; i<=15; i++){ 
			a.add(i);
		}
		for(int i = 5; i>=0; i--){ 
			b.add(i);
		}	

		System.out.println(b.mystery4());		// 2.


	}   
	public ArrayIntList mystery4() {
	    ArrayIntList result = new ArrayIntList(elementData.length);
	    if (size > 2) {
        result.add(elementData[0]);
        for (int i = 1; i < size; i++) {
            int a = result.get(i - 1);
            int b = elementData[i + 2];
            result.add(a + b);
	        }
	    }
	    return result;
	}
	
    public ArrayIntList() {
        this(DEFAULT_CAPACITY);
    }
    private ArrayIntList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Capacity must be at least 0: " + capacity);
        }
        elementData = new int[capacity];
    }
    public void add(int value) {
        add(size, value);
    } 
    public void add(int index, int value) {
        checkIndex(index, 0, size);
        ensureCapacity(size + 1);
        
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = value;
        size++;
    }    
    public boolean contains(int value) {
        return indexOf(value) != -1;
    } 
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
    public int get(int index) {
        checkIndex(index);
        return elementData[index];
    }  
    public int getCapacity() {
        return elementData.length;
    }
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elementData[i] == value) {
                return i;
            }
        }
        return -1;
    }  
    public boolean isEmpty() {
        return size == 0;
    }
    public Iterator<Integer> iterator() {
        return new ArrayIntListIterator(this);
    } 
    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        size--;
    }  
    public int size() {
        return size;
    }
    public String toString() {
        String result = "[";
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result += ", ";
            }
            if (i < elementData.length) {
                result += elementData[i];
            } else {
                result += "OOB!";
            }
        }
        result += "]";
        return result;
    }
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
    private static class ArrayIntListIterator implements Iterator<Integer> {
        private ArrayIntList list;    // list to iterate over
        private int position;          // current position within the list
        private boolean removeOK;      // whether it's okay to remove now
        public ArrayIntListIterator(ArrayIntList list) {
            this.list = list;
            position = 0;
            removeOK = false;
        }        
        public boolean hasNext() {
            return position < list.size();
        }      
        public Integer next() {
            if (!hasNext())
                throw new NoSuchElementException();
            int result = list.get(position);
            position++;
            removeOK = true;
            return result;
        }    
        public void remove() {
            if (!removeOK)
                throw new IllegalStateException();
            list.remove(position - 1);
            position--;
            removeOK = false;
        }
    }    
}
