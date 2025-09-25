package Sorting;

public class CountSort {

    
      /* Printing method */
      static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
     /* Finding max number in array */
    static int maxTerm(int arr[]){
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            if(max<arr[i]){
                max=arr[i];
            }
        }
        return max;
    }
    /* Counting sort but not stable. */
    static int[] countSortNoSt(int arr[]){
        int max=maxTerm(arr);
        int[] count=new int[max+1];  // Count Array

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;            // Counting number of elements in array
        }
        int k=0;
        for(int i=0;i<count.length;i++){
            for(int j=0;j<count[i];j++){
                arr[k++]=i;               // Placeing all numbers into array
            }
        }
        return arr;
    }

    /* Counting Sort with stablity. */
    static int[] countSort(int arr[]){
        int max=maxTerm(arr);
        int[] count=new int[max+1];  // Count Array

        for(int i=0;i<arr.length;i++){
            count[arr[i]]++;            // Counting number of elements in array
        }
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];      // finding the last position of all index in arr
        }
        int[] newarr=new int[arr.length];
        /* Find the inex of each element in the originral array and put into ans array. */
        for(int i=arr.length-1;i>=0;i--){  
            int index= count[arr[i]]-1;   // finding index where the arr[i] is placed
            newarr[index]=arr[i];         // placing value
            count[arr[i]]--;        // dexrement the position of number from count
        }
        return newarr;
    }
    
     public static void main(String[] args) {
        
        int[] arr={2,3,2,4,0,1,4,1,0,2};
        arr=countSortNoSt(arr);
        // Time Cmplexity is O(n+k) where k is disting elements in array
        // Space complity id O(n+k)
        printArr(arr);
    }
}
