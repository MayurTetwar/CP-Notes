package Queue;
import java.util.*;

public class BasicOpretion {
    public static void main(String[] args) {
        
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        q.add(3);
        q.add(5);
        q.add(7);
        System.out.println(q);
        //System.out.println(q.size());
        //q.poll();
        //q.remove();
        //System.out.println(q);
        // System.out.println(q.peek());
        // System.out.println(q.element());
        // System.out.println(q.size());
        Queue<Integer> helper=new LinkedList<>();

        while (q.size()>0) {
            System.out.print(q.peek()+" ");
            helper.add(q.remove());
        }
        while(helper.size()>0){
            q.add(helper.poll());
        }
        int[] arr={89,4,4,3};
        for(int i:arr){
            System.out.println(i);
        }
            System.out.println(q);
    }
}
