package ArrayCPOneD;

import java.util.HashMap;

public class SubArrayEqualToK {


    public static void main(String[] args) {
        
        int[] A={4, 2, 2, 6, 4};
        int B=6;

        int n=A.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int xor=0;
        int count=0;
        map.put(0,1);
        for(int i=0;i<n;i++){
            xor^=A[i];
            if(map.containsKey(xor^B)){
                count+=map.get(xor^B);
            }
            map.put(xor,map.getOrDefault(xor,0)+1);
        }
        System.out.println(count);
    }
}
