import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Program 1 Example

public class Final {
	private static void testMethod1() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		for (int i = 0; i < 10; i++)
		{
			myStack.push(i);
		}	
		mystery1(myStack);
		print(myStack);      							// 1.
	}		
	
	public static void main(String[] args) {
		testMethod1();
	}
	public static void mystery1(Stack<Integer> s) {
	    Queue<Integer> q = new LinkedList<Integer>();
	    while (!s.isEmpty()) {
	        q.add(s.pop());
	    }
	    while (!q.isEmpty()) {
	        s.push(q.remove());
	    }
	}

	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();
		 while ( e.hasMoreElements() )
		      System.out.print( e.nextElement() + " " );
		    System.out.println();
	}
} 
