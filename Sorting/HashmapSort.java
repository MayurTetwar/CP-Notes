package Sorting;
import java.util.*;

class HashmapSort {
    public static void main(String[] args) {
        
      int[] nums={1,1,1,2,2,3};
     HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        System.out.println(map.entrySet());

        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(map.entrySet());
        Collections.sort(entries, (entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));
        

      }
}