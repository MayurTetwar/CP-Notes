package ArrayCPOneD.PrefixSum;

import java.util.*;

/* Check if we can partition the array into two subarrays with equal sum. More
formally, check that the prefix sum of a part of the array is equal to the suffix
sum of rest of the array. */

class Problem3{

    static Scanner sc= new Scanner(System.in);   

    public static void main(String[] args) {
        
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];  
        System.out.println("Enter "+n+" number of array: ");
           for(int i=0;i<n;i++){
             arr[i]=sc.nextInt();   
           } 

        boolean result = eqalSumPartition(arr);
        if(result)
            System.out.println("Yes, Array conatin similar sum subarray .");
        else
            System.out.println("No, Array not conatin similar sum subarray .");

    }
    //  static boolean eqalSumPartition(int arr[]){

    //     int i,n=arr.length;
        
    //     arr= getPrefixSumArray(arr);

    //     for(i=0;i<(n-1);i++){
    //         if(arr[i]==(arr[n-1]-arr[i])){
    //            return true;
    //         }
    //     }
    //    return false;
    // }   
    // static int[] getPrefixSumArray(int arr[]){
    //     int i,n=arr.length-1;
            
    //     for(i=1;i<=n;i++){
    //         arr[i]+=arr[i-1];
    //     }
    //     return arr;
    // }  
    static boolean eqalSumPartition(int arr[]){
    
        int i,n=arr.length;
        int totalSum= getTotalSum(arr);
        int PrefixSum=0;
        for(i=0;i<n;i++){
            PrefixSum += arr[i];
            int suffixSum= totalSum-PrefixSum;
            if(suffixSum==PrefixSum)
                return true;
        }
        return false;
    }   
    static int getTotalSum(int arr[]){

        int totalSum=0;
        for(int i=0;i<arr.length;i++){
            totalSum+= arr[i];
        }
        return totalSum;
    }
}