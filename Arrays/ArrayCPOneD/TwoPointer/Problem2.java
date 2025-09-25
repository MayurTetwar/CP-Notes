package ArrayCPOneD.TwoPointer;

import java.util.*;

/* Sort array as all even integer are first and odd number at last. */
public class Problem2 {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);   
      
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           } 
        arr=getSortArray(arr);
        Problem1.printArray(arr);
    }
    static int[] getSortArray(int arr[]){
        int right=arr.length-1,left=0;
     
        while (left<right) {
            if(arr[left]%2!=0 && arr[right]%2==0){
                Problem1.swap(arr, left, right);
                left++;
                right--;
            }
            if(arr[left]%2==0){
                right--;
            }
            if(arr[right]%2==0){
                left++;
            }
        }
        return arr;
    }
}
