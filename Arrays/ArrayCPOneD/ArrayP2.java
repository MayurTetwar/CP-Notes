package ArrayCPOneD;
import java.util.*;

 /*  Unique Number */
public class ArrayP2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);   
        
        System.out.println("Enter size of Array: ");
        int n= sc.nextInt();
         
        int[] arr=new int[n];
        System.out.println("Enter "+arr.length+" number of array: ");
           for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
           }

       int uniqueNumber=getUnique(arr);
       if(uniqueNumber == 0)
       System.out.println("No such Number is Present");
       else
       System.out.println("The unique number is "+ uniqueNumber);   
    }
    static int getUnique(int arr[]){

   // method 1 but not valid for all test case

   //   for(int i=0;i<arr.length;i++){
   //       int count=0;
   //        for(int j=i+1;j<arr.length;j++){
   //          if(arr[i]==arr[j])
   //             count++;
   //        }
   //        if(count==0)
   //           return arr[i];
   //     }
   //     return 0;

   // method 2 but not valid for all test case

   //   for(int i=0;i<arr.length;i++){
   //      for(int j=i+1;j<arr.length;j++){
   //         if(arr[i]==arr[j]){
   //            arr[i]=-1;
   //            arr[j]=-1;
   //         }
   //      }
   //   }
   //   for(int i=0;i<arr.length;i++){
   //        if(arr[i]>0)
   //           return arr[i];
   //   }
   //    return 0;

   // method 3 best using XOR operetion

       int result=0;
       for(int i=0; i<arr.length; i++) {
           result = result^arr[i];
           System.out.println(result);
       }
     return result;

     // here, if a=10 and b=6 then a^b is 12
     // as a->1010 and b->0110 by using XOR opretion i.e. if both are same then 0 other wise 1
     //     1 0 1 0
     //     0 1 1 0
     //     1 1 0 0 -> 12
    }
}
