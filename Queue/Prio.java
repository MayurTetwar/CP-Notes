package Queue;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Prio {
    public static void main(String[] args) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->(Integer.compare(a, b)));
        // Add element in incresing order

        PriorityQueue<Integer> pqr = new PriorityQueue<>(Comparator.reverseOrder());
        // Add element in desending order
        pq.poll();
        /*
         * class TripleComparator implements Comparator<Triple> {
         * 
         * @Override
         * public int compare(Triple t1, Triple t2) {
         * if(t1.delta < t2.delta) {
         * return 1;
         * }
         * return -1;
         * }
         * }
         */
        // Below two statments are same
        /*
         * PriorityQueue<Pair> Q=new
         * PriorityQueue<>(Comparator.comparingInt(pair->pair.cost));
         */
        // PriorityQueue<Triple> pq = new PriorityQueue<>((a, b) ->
        // Double.compare(b.delta, a.delta))
        // using particular class value

        /*
         * PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
         * 
         * @Override
         * public int compare(Integer num1, Integer num2) {
         * double ratio11 = (double) arr[num1][0] / arr[num1][1];
         * double ratio12 = (double) (arr[num1][0]+1) / (arr[num1][1]+1);
         * double ratio21 = (double) arr[num2][0] / arr[num2][1];
         * double ratio22 = (double) (arr[num2][0]+1) / (arr[num2][1]+1);
         * 
         * return Double.compare(ratio22-ratio21,ratio12-ratio11);
         * }
         * });
         */
         
    
        //  PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer a,Integer b){
        //         int sum1=map.get(a);
        //         int sum2=map.get(b);
        //         if(sum1!=sum2)return Integer.compare(sum2,sum1);
        //         if(a>b)return 1;
        //         return -1; 
        //     }
        // });
        
    }
}
