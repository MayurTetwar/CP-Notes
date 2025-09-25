package ArrayCPOneD.TwoPointer;

import java.util.*;

/* Given an integer array 'a' sorted in non-decreasing order, return an array of 
   the squares of each number sorted in non-decreasing order. */
public class Problem3 {
    public static void main(String[] args) {
         Scanner sc= new Scanner(System.in);   
      
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           } 
      arr = getSquareArray(arr);
      printArray(arr);
    }
      static int[] getSquareArray(int[]arr){

        int left=0,right=arr.length-1;
        int[] ans=new int[arr.length];
        int k=right;
        while (left<=right) {
          arr[left]=Math.abs(arr[left]);
          arr[right]=Math.abs(arr[right]);

          if(arr[left]>arr[right]){
            ans[k]=arr[left]*arr[left];
            left++;
          }else{
            ans[k]=arr[right]*arr[right];
            right--;
          }
          k--;
        }
        printArray(ans);
        return ans;
      }
      static void printArray(int arr[]){
        System.out.println("New Array is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
      }  
//    static int[] getSquareArray(int arr[]){

//     int i,n=arr.length-1;
//         for(i=0;i<=n;i++){
//             arr[i]*=arr[i];
//         }
//         for(i=0;i<n;i++){
//               for(int j=0;j<n;j++){
//                  if(arr[j]>arr[j+1]){
//                      Problem1.swap(arr, j, j+1);
//                  }
//              }
//         }     
//     return arr;
//    }
}
