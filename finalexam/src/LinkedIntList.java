import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

//Final Program 3 Example
public class LinkedIntList {
    private ListNode front;   
    private String name = "front";     
    public static void main(String[] args) {
		LinkedIntList s = new LinkedIntList(); 
		s.add(1); s.add(2);s.add(1);s.add(2);s.add(1);s.add(2);
		s.add(2);s.add(1);s.add(2);s.add(2);s.add(1);		


		System.out.println(s.mystery7(1));  		// 3.  
		
	}
	public int mystery7(int n) {
	    int result = -1;
		    int index = 0;
		    ListNode current = this.front;
	    while (current != null) {
		        if (current.data != n) {
		            result = index;
		        }
		        index++;
		        current = current.next;
		    }
		    return result;
		}	

    public LinkedIntList() {
        front = null;
    }
    public LinkedIntList(int... elements) {
        this("front", elements);
    }
    public LinkedIntList(String name, int... elements) {
        this.name = name;
        if (elements.length > 0) {
            front = new ListNode(elements[0]);
            ListNode current = front;
            for (int i = 1; i < elements.length; i++) {
                current.next = new ListNode(elements[i]);
                current = current.next;
            }
        }
    }
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value, front);
        } else {
            ListNode current = front;
            while (current.next != null) {
                current = current.next;
            } 
            current.next = new ListNode(value);
        }
    }
    public boolean equals(Object o) {
        if (o instanceof LinkedIntList) {
            LinkedIntList other = (LinkedIntList) o;
            return toString().equals(other.toString()); 
        } else {
            return false;
        }
    }
    public int get(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = front;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
    }
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
    public String toFormattedString() {
        ListNode.clearCycleData();   
        String result = this.name;     
        ListNode current = front;
        boolean cycle = false;
        while (current != null) {
            result += " -> [" + current.data + "]";
            if (current.cycle) {
                result += " (cycle!)";
                cycle = true;
                break;
            }
            current = current.__gotoNext();
        }
        if (!cycle) {
            result += " /";
        }      
        return result;
    }
    public String toString() {
        return toFormattedString();
    }
    public static class ListNode {
        private static final List<ListNode> ALL_NODES = new ArrayList<ListNode>();
        
        public static void clearCycleData() {
            for (ListNode node : ALL_NODES) {
                node.visited = false;
                node.cycle = false;
            }
        }       
        public int data;          
        public ListNode next;     
        public boolean visited;   
        public boolean cycle;   
        public ListNode() {
            this(0, null);
        }
        public ListNode(int data) {
            this(data, null);
        }
        public ListNode(int data, ListNode next) {
            ALL_NODES.add(this);
            this.data = data;
            this.next = next;
            this.visited = false;
            this.cycle = false;
        }    
        public ListNode __gotoNext() {
            return __gotoNext(true);
        }   
       public ListNode __gotoNext(boolean checkForCycle) {
            if (checkForCycle) {
                visited = true;
                
                if (next != null) {
                    if (next.visited) {
                        next.cycle = true;
                    }
                    next.visited = true;
                }
            }
            return next;
        }
    }
}
