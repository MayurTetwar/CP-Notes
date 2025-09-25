package ArrayCPOneD.TwoPointer;

import java.util.*;

  /* Sort array which contain only 0 and 1 */
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
        
         arr=getSortArray(arr);
         printArray(arr);
    }
    static void printArray(int arr[]){
        System.out.println("Sorted Array is : ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
     static int[] getSortArray(int arr[]){
       
        int left=0,right=arr.length-1;
          // Two pointer approch left and right
        while (left<right) {
            if(arr[left]==1 && arr[right]==0){
               swap(arr,left,right);
               right--;
               left++;
            }if(arr[left]==0){
                left++;
            }if(arr[right]==1){
                right--;
            } 
        }
        return arr;
    }
    static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    // static int[] getCountZero(int arr[]){

    //     int count=0,n=arr.length;
    //     for(int i=0;i<n;i++){
    //         if(arr[i]==0)
    //           count++;
    //     }
    //     for(int i=0;i<n;i++){
    //         if(i<count)
    //           arr[i]=0;
    //         else
    //           arr[i]=1;
    //     }
    //     return arr;
    // }
}
