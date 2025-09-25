package ArrayCPOneD;

import java.util.*;

public class ArraysP6 {

    static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void main(String[] args) {
        
      //  1664. Ways to Make a Fair Array
     
       int[] nums = {2,1,6,4};
       int oddprefix[]=new int[nums.length];
       int evenprefix[]=new int[nums.length];
       int odd=0;
       int even=0;
       for(int i=0;i<nums.length;i++){
           if(i%2==0){
               even+=nums[i];
               oddprefix[i]=odd;
               evenprefix[i]=even;                     
           }
           else{
               odd+=nums[i];
               oddprefix[i]=odd;
               evenprefix[i]=even;
           }
       }
       printArr(evenprefix);
       System.out.println();
       printArr(oddprefix);
       int count=0;
       for(int i=0;i<nums.length;i++){
           if(i%2!=0){
               int newodd=oddprefix[i]-nums[i]+even-evenprefix[i];
               int neweven=evenprefix[i]+odd-oddprefix[i];
               if(newodd==neweven){
                   count++;
               }
           }
           else{
              int neweven=evenprefix[i]-nums[i]+odd-oddprefix[i];
               int newodd=oddprefix[i]+even-evenprefix[i];
               if(newodd==neweven){
                   count++;
               } 
           }
       }
       System.out.println();
      System.out.println(count);
    }
}
