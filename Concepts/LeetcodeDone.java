package Concepts;

import java.util.*;

public class LeetcodeDone {

    /* 2368. Reachable Nodes With Restrictions */
    public static void main(String[] args) {
        
        int n = 7;
        int[][] arr = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
        int[] res = {4,5};

        HashSet<Integer> set=new HashSet<>();
        for(int i:res)set.add(i);
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        for(int[] a:arr){
            list.get(a[0]).add(a[1]);
            list.get(a[1]).add(a[0]);
        }
        // for(List<Integer> li:list){
        //     System.out.println(li);
        // }
        boolean[] visi=new boolean[n];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        visi[0]=true;
        int count=1;
        while (!q.isEmpty()) {
            int start=q.poll();
            List<Integer> li=list.get(start);
            for(int end:li){
                //q.add(end);
                if(!set.contains(end) && !visi[end]){
                    q.add(end);
                    count++;
                }
                visi[end]=true;
            }
        }
        System.out.println(count);
    }
}
