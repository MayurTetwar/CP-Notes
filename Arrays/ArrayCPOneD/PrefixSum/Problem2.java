package ArrayCPOneD.PrefixSum;

import java.util.*;

/* Given an array of integers of size n. Answer q queries where you need to print the sum of
values in a given range of indices from 1 to r (both included).
Note: The values of 1 and r in queries follow 1-based indexing. */

public class Problem2 {

    static Scanner sc= new Scanner(System.in);   

    public static void main(String[] args) {
                
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n+1];  
        System.out.println("Enter "+(arr.length-1)+" number of array: ");
           for(int i=1;i<=n;i++){
             arr[i]=sc.nextInt();   // Not put value to 0 index ,As we use 1-indexing method
           } 

        getSum(arr);
    }

      static void getSum(int []pref){
       
        int i,n=pref.length-1,l,r;
        System.out.println("Enter number of Query : ");
         int q=sc.nextInt();

         for(i=1;i<=n;i++){   // Here, Array get only one time traverse
          pref[i]+=pref[i-1];
         }
         for(i=1;i<=q;i++){    // Each query solution get by only subtraction
            System.out.println("Enter the range between 1 and "+(pref.length-1)+" : ");
              l=sc.nextInt();
              r=sc.nextInt();
            System.out.println("The sum between given range is "+ (pref[r]-pref[l-1]));
          }
      }

    /* My code (Not so optimise) */
    // static void getSum(int[] arr){

    //     int i=1,l,r;
    //     System.out.println("Enter number of Query : ");
    //     int q=sc.nextInt();
    //       for(i=1;i<=q;i++){
            
    //         System.out.println("Enter the value of Start and End Index between 1 and "+(arr.length-1)+" : ");
    //         int sum=0;
    //         l=sc.nextInt();
    //         r=sc.nextInt();
    //              while(l<=r){     // Here , Array get always traverse (Get extra time)
                                     // for each query 
    //                 sum=arr[l]+sum;
    //                 l++;
    //              }
    //       System.out.println("The sum between given range is "+sum);
    //     }
    // }
}
