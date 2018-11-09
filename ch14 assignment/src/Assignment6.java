import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//Name,Class,Date..etc.. Header

public class Assignment6 {

	
	public static void main(String[] args) {
		//testSeeingThreeMethod();
		//testTwoStacksAreEqualMethod();
		//testIsMirrored();
	
	}
	
	public static void seeingThree(Stack<Integer> s) {
		
		 /*********Write Code Here************/
		
	    }
	    
	
	
	public static boolean twoStacksAreEqual(Stack<Integer> s1, Stack<Integer> s2) {
		
		 /*********Write Code Here************/
		
	}

	public static boolean isMirrored(Queue<Integer> q) {
		
		 /*********Write Code Here************/
		
	}


	private static void testIsMirrored() {

		Queue<Integer> myQueueP  = new LinkedList<Integer>();;
	
		for (int i = 0; i < 5; i++)
		{
		
			System.out.print(i);
			myQueueP.add(i);
			
		}
		for (int i = 3; i >= 0 ; i--)
		{
			
			System.out.print(i);
			myQueueP.add(i);
				
		}
		
		
		System.out.println();
		
		System.out.println(isMirrored(myQueueP) + " isMirrord");
		
	}


	private static void testTwoStacksAreEqualMethod() {
		Stack<Integer> myStack1  = new Stack<Integer>();	
		Stack<Integer> myStack2  = new Stack<Integer>();
		Stack<Integer> myStack3  = new Stack<Integer>();
		Stack<Integer> myStack4  = new Stack<Integer>();
	
		for (int i = 0; i < 5; i++)
		{
			myStack1.push(i);
			myStack2.push(i);
			myStack4.push(i);
		
		}
		for (int i = 0; i < 6; i++)
		{
			myStack3.push(i);
		
		}
	
		System.out.println(twoStacksAreEqual(myStack1,myStack2) + " Same Stack ");
		
		System.out.println(twoStacksAreEqual(myStack3, myStack4) + " Not Same Stack");
		
	}


	private static void testSeeingThreeMethod() {
		Stack<Integer> myStack  = new Stack<Integer>();	
		
		for (int i = 0; i < 5; i++)
		{
			myStack.push(i);

		}
		
		
		System.out.println();
		print(myStack);
		
		seeingThree(myStack);
	
		print(myStack);
		
	}

	private static void print(Stack<Integer> s) {
		Enumeration<Integer> e = s.elements();

		 while ( e.hasMoreElements() )
		      System.out.print( e.nextElement() + " " );
		    System.out.println();

	
	}

} //end of Assignment6 
