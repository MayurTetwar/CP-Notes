package Graph;

import java.util.*;

public class BFS {
    public static void main(String[] args) {
        
    }
    public HashSet<Integer> helper(List<List<Integer>> rooms){
        HashSet<Integer> set=new HashSet<>();
        Queue<Integer> que=new LinkedList<>();
        que.add(0);
        while(!que.isEmpty()){
            int curr=que.poll();
            if(set.contains(curr))continue;
            set.add(curr);
            for(int num:rooms.get(curr)){
                if(!set.contains(num)){
                    que.add(num);
                }
            }
        }
        return set;
    }
}
