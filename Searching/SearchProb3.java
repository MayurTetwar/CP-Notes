package Searching;

public class SearchProb3 {

    /* You are given an integer mountain array arr of length n where the values increase 
    to a peak element and then decrease.
    Return the index of the peak element. */
    static int peakIndexInMountainArray(int[] arr) {
        
        int start=0;
        int end=arr.length-1;
        int ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<arr[mid+1]){
                start=mid+1;
                ans=mid+1;  
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
       
        
    }
}
