package Algorithum;
class Kadnes{
    public static void main(String[] args) {
        

    }
    class Solution {
        public int maxSubArray(int[] arr) {
            int curr=0;
            int max=Integer.MIN_VALUE;
            int n=arr.length;
    
            for(int i=0;i<n;i++){
                curr+=arr[i];
                max=Math.max(max,curr);
                curr=Math.max(curr,0);
            }
            return max;
        }
    }
}