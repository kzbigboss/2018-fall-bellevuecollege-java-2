import java.util.*;

public class homework {

    public static void main(String[] args){
        Stack<Integer> data = new Stack<Integer>();
        int[] dataInput = {5, -10, 15, 0, -5, 100};

        for (int i = 0; i < dataInput.length; i++){
            data.push(dataInput[i]);
        }

        splitStack(data);
    }

    public static void splitStack(Stack<Integer> s){
        Queue<Integer> q = new LinkedList<Integer>();

        int size = s.size();

        for (int i = 0; i < size; i++){
            q.add(s.pop());
        }

        for (int i = 0; i < size; i++){
            int n = q.remove();

            if (n < 0){
                s.push(n);
            } else {
                q.add(n);
            }
        }

        size = q.size();

        for (int i = 0; i < size; i++){
            s.push(q.remove());
        }

    }

}
