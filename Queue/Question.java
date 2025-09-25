package Queue;
import java.util.*;

public class Question {

    public static ArrayList<Integer> rearrangeQueue(int N, Queue<Integer> q) {
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<N/2;i++){
            list.add(q.remove());
        }
        int ind=1;
        for(int i=0;i<N/2;i++){
            list.add(i+ind, q.remove());
            ind++;
        }
        return list;
    }


    // Reverse First kth numbers
    static void reverse(Queue<Integer> Q,int k){
        Stack<Integer> stk=new Stack<>();
        int i=0;
        while(!Q.isEmpty() && i<k){
            stk.push(Q.remove());
            i++;
        }
        while(!stk.isEmpty()){
            Q.add(stk.pop());
        }
        int size=Q.size();
        while(k<size){
            int num=Q.remove();
            Q.add(num);
            k++;
        }
    } 


    public static void main(String[] args) {
        
        Queue<Integer> Q=new LinkedList<>();
        Q.add(1);
        Q.add(2);
        Q.add(3);
        Q.add(4);
        Q.add(5);
        Q.add(6);
        System.out.println(Q);
        System.out.println(rearrangeQueue(6, Q));

    }
}
