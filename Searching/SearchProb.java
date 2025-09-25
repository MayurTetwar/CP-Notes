package Searching;

public class SearchProb {

    /* Seach element in sortead array but dst occurrance of element index is ans. */
    static int binarySearchFirstOccurs(int[] arr,int target){

        int start=0;
        int end=arr.length-1;
        int index=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                index=mid;
                end=mid-1;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return index;
    }
    static int binarySearchLastOccurs(int[] arr,int target){

        int start=0;
        int end=arr.length-1;
        int index=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if(arr[mid]==target){
                index=mid;
                start=mid+1;
            }else if(arr[mid]>target){
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return index;
    }
    /* Find the square root of number , if not a perfect square than return floor integer value. */
    static int getSuareRoot(int x){

        int start=0;
        int end=x-1;
        int ans=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            int val=mid*mid;
            if(val==x){
                return mid;
            }else if(val>x){
                end=mid-1;
            }else{
                start=mid+1;
                ans=mid;
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        
        int[] arr={1,1,2,2,2,2,3,4,7,7};
        int x=7;
        System.out.println(binarySearchFirstOccurs(arr, x));
        System.out.println(binarySearchLastOccurs(arr, x));
  
        x=24;
        System.out.println(getSuareRoot(x));
    }
}
