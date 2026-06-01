package Algorithum;
class Kadnes{
    public static void main(String[] args) {
        
        System.out.println(maxSubArray(new int[]{3,2,-9,8}));
    }
    public static int maxSubArray(int[] arr) {
            int curr=0;
            int max=Integer.MIN_VALUE;
            int n=arr.length;
            for(int i=0;i<n;i++){
                curr+=arr[i];
                max=Math.max(max,curr);
                if(curr<0){
                    curr=0;
                }
            }
            return max;
        }
}