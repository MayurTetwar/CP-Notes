package ArrayCPOneD.PrefixSum;

import java.util.*;

/* To get prefix sum of any array. */
public class Problem1 {
    public static void main(String[] args) {
        
         Scanner sc= new Scanner(System.in);   
        
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           } 
        arr=getPrefixSumArray(arr);
        printArray(arr);
    }
    static int[] getPrefixSumArray(int arr[]){
        int i,n=arr.length-1;
            
        for(i=1;i<=n;i++){
            arr[i]+=arr[i-1];
        }
        return arr;
    }   
    static void printArray(int arr[]){
        System.out.println("PrefixSum Array is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

}
