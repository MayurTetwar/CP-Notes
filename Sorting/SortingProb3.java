package Sorting;

import java.util.*;

public class SortingProb3 {

    // All majority element which are greter the n/3 using sorting
    static List<Integer> majorityElement(int[] nums) {
        
      List<Integer> list=new ArrayList<>();
      Arrays.sort(nums);
      int n=nums.length;
      int i=0,j=0;
      while (j<n) {
          int count=0;
          while (j<n && nums[j]==nums[i]) {
            count++;
            j++;
          }
          if(n/3<count){
             list.add(nums[i]);
          }
          i=j;
      }
      return list;
    }

    public static void main(String[] args) {
        
        int[] arr={1,3,3,4,1,1,2,3};

        List<Integer> list=majorityElement(arr);
        System.out.println(list);
    }
}
