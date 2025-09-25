package ArrayCPOneD;

import java.util.*;
// Reverse Array
// public class ArrayProblems {
//     public static void main(String[] args) {
//          Scanner sc= new Scanner(System.in);   
        
//         System.out.println("Enter size of Array: ");
//         int n= sc.nextInt();
         
//         int[] arr=new int[n];
//         System.out.println("Enter "+arr.length+" number of array: ");
//            for(int i=0;i<arr.length;i++){
//              arr[i]=sc.nextInt();
//            } 
//         getReverseArray(arr);
//         for(int i=0;i<arr.length;i++){
//             System.out.print(arr[i]+" ");
//         }
//     }

//       static void swap(int arr[],int i ,int j){
//         int temp=arr[i];
//         arr[i]=arr[j];
//         arr[j]=temp;
//       }

//       static void getReverseArray(int arr[]){
//          int i=0,j=arr.length-1;
//           while (i<j) {
//             swap(arr, i, j);
//             i++;
//             j--;
//           }
//       }

// }

 /* rotation Arrys */
 /* 
 public class ArrayProblems {
      public static void main(String[] args) {
           Scanner sc= new Scanner(System.in);   
          
          System.out.println("Enter size of Array: ");
          int n= sc.nextInt();
           
          int[] arr=new int[n];
          System.out.println("Enter "+n+" number of array: ");
             for(int i=0;i<n;i++){
               arr[i]=sc.nextInt();
             } 

            System.out.println("Enter the number of rotation: ");
            int k= sc.nextInt();

            RotateArray(arr,k);
            System.out.println("Rotate Array by "+k+" is : ");
             for(int i=0;i<arr.length;i++){
                 System.out.print(arr[i]+" ");
             }
       } 
     /* My Code */
        /*     static void RotateArray(int[] arr,int k){
              int n=arr.length;
              k = k % n;

              for(int i=0;i<k;i++){
                for(int j=n-1;j>0;j--){
                   int temp=arr[j];
                   arr[j]=arr[j-1];
                   arr[j-1]=temp;
                 } 
               } 
            }
      }
      */
      /* Method From Youtube */
     /*  static void swap(int arr[],int i ,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
      }

      static void getReverseArray(int arr[],int i,int j){
          while (i<j) {
            swap(arr, i, j);
            i++;
            j--;
          }
      }

      static void RotateArray(int arr[],int k){
        int n=arr.length;
        k = k % n;
        getReverseArray(arr,0,n-k-1);
        getReverseArray(arr, n-k, n-1);
        getReverseArray(arr, 0, n-1);
      }
}   */

