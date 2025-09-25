package Sorting;

public class MergeSort {

      /* Printing method */
      static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    static void mergeSort(int[] arr,int l,int r){

        if(l>=r) return; // Array length is 1;

        int mid=(l+r)/2;  // Finding middle index
        mergeSort(arr, l, mid);  // Sorting 1st half of array
        mergeSort(arr, mid+1, r);  // Sorting 2nd half of array
        merge(arr,l,mid,r);  // mergeing above 2 sorted sub array
        
    }
    static void merge(int[] arr,int l,int mid,int r){

        int n1=mid-l+1;
        int n2=r-mid;
        int[] left=new int[n1];  // left subArray
        int[] right=new int[n2];  // right subArray

        for(int i=0;i<n1;i++){
            left[i]=arr[l+i];   // adding valus to left array
        }
        for(int i=0;i<n2;i++){
            right[i]=arr[mid+i+1]; // adding valur to right array
        }
        
        int i=0,j=0,k=l;  
        while (i<n1 && j<n2) {   // merging this te=wo array in sorted manner
            if(left[i]<=right[j]){
                arr[k++]=left[i++];
            }else{         
                arr[k++]=right[j++];
            }
        }
        
        // if any number is remaining then add those number
        while (i<n1) {   
            arr[k++]=left[i++];
        }
        while (j<n2) {
             arr[k++]=right[j++];
        }

    }
    public static void main(String[] args) {
        
        int[] arr={7,20,4,11,8,2};    
        mergeSort(arr, 0, arr.length-1);  
        printArr(arr);
        // The Time complexity in any case is always O(n(log n)).
        // The Space Complexity is O(log n). 
    }
}
