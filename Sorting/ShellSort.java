package Sorting;

import java.util.*;

public class ShellSort {

    /* Printing method */
    static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    static void shell_Sort(int[] arr){
        
        int n=arr.length;
        // Taking n/2 list and after each interval n/2 again //
        for(int interval=n/2;interval>0;interval/=2){

            for(int i=interval;i<n;i++){

                int temp=arr[i];
                int j=i;
                while(j>=interval && arr[j-interval]>temp){
                    arr[j]=arr[j-interval];
                    j-=interval;
                }

              arr[j]=temp;
            }
        }
    }

    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        
      System.out.println("Enter size of Array:");
      int n=sc.nextInt();

      int arr[] = new int[n];
      System.err.println("Enter "+n+" number for array: ");
      for(int i=0;i<n;i++){
        arr[i]=sc.nextInt();
      }
      shell_Sort(arr);
      printArr(arr);
      
    }
}
