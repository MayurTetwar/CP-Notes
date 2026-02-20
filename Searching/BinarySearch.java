package Searching;


public class BinarySearch {

    static int binarySearch(int[] arr,int target){
        int start=0;
        int end=arr.length-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        
        int[] arr={1,3,6,8,10,14,36,78};
        int target=9;
        System.out.printf("%d is at index %d",target,binarySearch(arr, target));
    }
}
