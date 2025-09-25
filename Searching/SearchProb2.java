package Searching;

public class SearchProb2 {

    /* A rotated sorted array is a sorted array on which rotation operation has been
     perform some number of times . Given a rotate a sorted array, find the index of 
     minimum element in the array . 
     All elements are unique */
     static int getMinimumInRotateArr(int[] arr){

        int n=arr.length;
        int start=0;
        int end=n-1;
        int ans=-1;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]<=arr[n-1]){
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
     }
     static int getMinimumInRotateArrInDuplicateEle(int[] arr){

        int n=arr.length;
        int start=0;
        int end=n-1;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid] < arr[end]) {
                end = mid;
            } else if (arr[mid] > arr[end]) {
                start = mid + 1;  
            } else {
                end--; // Handle duplicates
            }
        }
        return arr[start]; 
     }
     /* Given in rotated array  of integer,ehich contain 
     distact elemnts  ans an integer target . Return the index of 
     target if not present then return -1. */
    static int getTargetIndex(int[] arr,int target){
    
        int start=0;
        int end=arr.length-1;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[mid]<arr[end]){
                if(arr[mid]<target && target<=arr[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }else{
                if(arr[mid]>target && target>=arr[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }     
        }
        return -1;
    }

    /* Search the element in soreted array with duplicate elements. */
    static int getTargetIndexInDuplicateEle(int[] arr,int target){
        int start=0;
        int end=arr.length-1;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                return mid;
            }else if(arr[start]==arr[mid] & arr[mid]==arr[end]){
                start++;
                end--;                  //1.reduce satrt and end if all are same
            }else if(arr[mid]<=arr[end]){  //2.Add here equal to
                if(arr[mid]<target && target<=arr[end]){
                    start=mid+1;
                }else{
                    end=mid-1;
                }
            }else{
                if(arr[mid]>target && target>=arr[start]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }     
        }
        return -1;
    }
   
    public static void main(String[] args) {
        
        int arr[] = {2,2,2,3,3,0,1,1,2,2,2};
        int index=getMinimumInRotateArr(arr);
        System.out.println(arr[index]);
        
        // int[] arr={1,1,1,2,2,3,1,1};
        // int target=3;
        // System.out.println(getTargetIndex(arr, target));

    }
}
