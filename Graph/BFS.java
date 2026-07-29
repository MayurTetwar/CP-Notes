package Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {

        

        List<List<Integer>> list =new ArrayList<>();

        int n=5;

    }
    public int helper(List<List<Integer>> list,int curr,int count){ 
        List<Integer> bande=list.get(curr);

        int ans=0;
        for(int num:bande){
                int res=helper(list,num,count+1);
                // ans=Math.max(ans,res);
        }
        return Math.max(ans,count);
    }


















    public HashSet<Integer> helper(List<List<Integer>> list){

        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> que=new LinkedList<>();
            System.out.println(1);

        
        que.add(0);
        set.add(0);

        while(!que.isEmpty()){
            int curr=que.poll();

            List<Integer> bande = list.get(curr);

            for(int num:bande){
                if(!set.contains(num)){
                    set.add(num);
                    que.add(num);
                
                }
            }
        }
        return set;
    }



}
