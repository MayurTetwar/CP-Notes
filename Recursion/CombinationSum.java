package Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {


    // LeetCode 39 (With Repetation of numbers)

    public List<List<Integer>> combinationSum(int[] arr, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        helper(ans,list,arr,0,0,target);
        return ans;
    }
    public void helper(List<List<Integer>> ans,List<Integer> list,int[] arr,int ind ,int sum ,int target){
        if(sum==target){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind>=arr.length || sum>target)return;
        list.add(arr[ind]);
        helper(ans,list,arr,ind,sum+arr[ind],target);
        list.remove(list.size()-1);
        helper(ans,list,arr,ind+1,sum,target);
    }


        // LeetCode 40 (Without Repetation of numbers)

        public List<List<Integer>> combinationSum2(int[] arr, int target) {
            List<List<Integer>> list=new ArrayList<>();
           Arrays.sort(arr);
           mycombinationSum2(arr, target, 0,new ArrayList<>(),list);
            return list;
        }
    
        static void mycombinationSum2(int arr[],int target,int start,List<Integer> current,List<List<Integer>> list){
    
            if(target==0){
                list.add(new ArrayList<>(current));
                return;
            }
            for(int i=start;i<arr.length;i++){
                if(arr[i]>target){
                    break;
                }
                if(i>start && arr[i]==arr[i-1]){
                    continue;
                }
                current.add(arr[i]);
                mycombinationSum2(arr, target-arr[i], i+1, current, list);
                current.remove(current.size()-1);
            }
            return;
         }
    
}
