package Sorting;

public class RadixSort {

    
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
     /* Counting Sort with stablity. */
     static void countSort(int arr[],int place){

        int[] count=new int[10];  // Count Array

        for(int i=0;i<arr.length;i++){
            count[(arr[i]/place)%10 ]++;            // Counting number of elements in array
        }
        for(int i=1;i<count.length;i++){
            count[i]+=count[i-1];      // finding the last position of all index in arr
        }
        int[] newarr=new int[arr.length];
        /* Find the inex of each element in the originral array and put into ans array. */
        for(int i=arr.length-1;i>=0;i--){  
            int index= count[(arr[i]/place)%10]-1;   // finding index where the arr[i] is placed
            newarr[index]=arr[i];         // placing value
            count[(arr[i]/place)%10]--;        // dexrement the position of number from count
        }
        for(int i=0;i<arr.length;i++){
            arr[i]=newarr[i];
        }
    }

    /* Radix Sort */
    static void radixSort(int arr[]){
        int max=maxTerm(arr);      // get maximum element 
        // apply counting sort to sort element based on place value
        for(int place=1;(max/place)>0;place*=10){
            countSort(arr, place);
        }
    }
   
    public static void main(String[] args) {
        
        int[] arr={43,453,626,894,0,3};
        radixSort(arr);
        // time Complexity is O(d*n) where d is max number of digits in it.
        // Space complexity id O(n)
        printArr(arr);
    }
}
