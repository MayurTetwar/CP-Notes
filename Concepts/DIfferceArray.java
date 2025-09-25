package Concepts;



// This is differce array problem in which , If you have to find sum or minas for
// particular range than 
// for sum => add at start and minus at end+1
// for diff => minnus at start and add at 
class DIfferceArray {
    public boolean isZeroArray(int[] arr, int[][] que) {
        int n=arr.length;
        int[] ans=new int[n];
        for(int a[]:que){
            ans[a[0]]-=1;
            if((a[1]+1)<n){
                ans[a[1]+1]+=1;
            }
        }
        for(int i=1;i<n;i++){
            ans[i]+=ans[i-1];
        }
        for(int i=0;i<n;i++){
            if(ans[i]+arr[i]>0)return false;
        }     
        return true;
    }
}