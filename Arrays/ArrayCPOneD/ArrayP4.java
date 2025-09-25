package ArrayCPOneD;

import java.util.*;
     /* Repeted Number */
public class ArrayP4 {
    public static void main(String[] args) {
        
         Scanner sc= new Scanner(System.in);   
        
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           } 
        int ans=getRepetedNum(arr);
        if(ans==-1)
           System.out.println("No repeted number is present");
        else
           System.out.println("Repeted first number is "+ans);   
    }

    static int getRepetedNum(int arr[]){
        
        for(int i=0;i<arr.length;i++){
            for(int j=i+1;j<arr.length;j++){
               if(arr[i]==arr[j])
                   return arr[i];
            }
        }
        return -1;
    }
}
