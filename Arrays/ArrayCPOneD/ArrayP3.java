package ArrayCPOneD;

import java.util.*;
   /* to find second largest and smallest number */
public class ArrayP3 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);   
        
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           }
        
        int[] arr2=arr.clone();

        int max=getSecMaxNumber(arr);
         for(int i=0;i<arr.length;i++){
            if(max==arr[i])
               arr[i]=Integer.MIN_VALUE;
         }
         System.out.println("Second Maximum :"+getSecMaxNumber(arr));

        int min=getSecMinNumber(arr2);
         for(int i=0;i<arr2.length;i++){
            if(min==arr2[i])
               arr2[i]=Integer.MAX_VALUE;
         }
         System.out.println("Second Minimum :"+getSecMinNumber(arr2));

    }
    static int getSecMaxNumber(int arr[]){
      
      int max=Integer.MIN_VALUE;

      for(int i=0;i<arr.length;i++){
          if(arr[i]>max){
            max=arr[i];
           }   
      }
      return max;
    }
    static int getSecMinNumber(int arr[]){
      
        int min=Integer.MAX_VALUE;
  
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
              min=arr[i];
            }   
        }
        return min;
      }
}
