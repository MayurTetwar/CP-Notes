package ArrayCPOneD;

// Arrays.sort(arr);  // Inbulit Or Predifined Method

/******* Soritng ******* */
/* 
import java.util.*;

class Allarray{
    public static void main(String[] args) {
    
    int[] arr= {1,2,3,4,5,6,7,8,9};
    int key=0;
    int result= findElement(arr,key);
       if(result==-1)
         System.out.println("Key is not found");
       else
         System.out.println(key+" present at "+result);
  
  
   } 
   public static int findElement(int arr[],int x){
      for(int i=0;i<arr.length;i++){
         if(arr[i]==x)
           return i;
         } 
        return -1;
      }
 }*/
 
 
 /*** Input Array ****/
/* 
 import java.util.*;

 class Dcoder
 {
   public static void main(String args[])
   { 
    Scanner sc=new Scanner(System.in);
   
    int[] arr=new int[5];
    int i, k;
    
    System.out.println("Enter "+arr.length+" element of array with sapce: ");
     for(i=0;i<arr.length;i++){
       arr[i]=sc.nextInt();
     }
    for(i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
     }
  }
}*/
  
/** Coping(Shallow copy) and Cloning(Deep cpoy) **/

/*
import java.util.*;

class Dcoder
 {
   public static void main(String args[])
   { 
    int[] arr= {1,2,3,4,5};
    int[] arr2 = arr;
    // Coping Reference 
    // arr2 and arr are ponits to 
    // same address
     
    System.out.println("Original Array : ");
    printArray(arr);
    System.out.println("Original Array2 : ");
    printArray(arr2);
   
    arr2[0]=0;
    arr2[1]=0;
    arr2[2]=0;
    
    System.out.println("Update Array : ");
    printArray(arr); 
    // 0 0 0 4 5
    System.out.println("Update Array2 : ");
    printArray(arr2);
    // 0 0 0 4 5 
  
    int[] arr= {1,2,3,4,5};
    int[] arr2 = arr.clone();
    
    System.out.println("Original Array : ");
    printArray(arr);
    System.out.println("Original Array2 : ");
    printArray(arr2);
   
    arr2[0]=0;
    arr2[1]=0;
    arr2[2]=0;
    
    System.out.println("Update Array : ");
    printArray(arr); 
    System.out.println("Update Array2 : ");
    printArray(arr2);
   } 
   
   public static void printArray(int arr[]){
     for(int i=0;i<arr.length;i++){
        System.out.print(arr[i]+" ");
     }
     System.out.println( );
   }
 } */
   
/** Problems **/
// import java.util.*;

// class Allarray
//  {
//    public static void main(String args[])
//    { 
//      Scanner sc=new Scanner(System.in);    
//       int n;
     
//      System.out.println("Enter size of array: ");
//      n=sc.nextInt();
     
//      int[] arr= new int[n];
//      System.out.println("Enter "+arr.length+" element of array with sapce: ");
//      for(int i=0;i<arr.length;i++){
//        arr[i]=sc.nextInt();
//        }
  //   System.out.println("Enter the element :");
  //   int x=sc.nextInt(); 
     
//      int[] newArray =getLargestAndSmallest(arr);
//      System.out.println("New array is :");
//      for(int i=0;i<newArray.length;i++){
//         System.out.print(newArray[i]+" ");
//      }
//    }  
   
//   /** Get lagest and Smallest element of array in new array */
//    static int[] getLargestAndSmallest(int arr[]){
    
//         int[] LargeSmallArr = new int[2];
//     /* 
//      int max=0, min=arr[0];
//      for(int i=0;i<arr.length;i++){
//         if(arr[i]>max)
//            max=arr[i];
//         if(min>arr[i])
//           min=arr[i];  
//      }
//      LargeSmallArr[0]=min;
//      LargeSmallArr[1]=max;
//      */
//       Arrays.sort(arr);        // Inblide Methods of Array Class0
//       LargeSmallArr[0]=arr[0];
//       LargeSmallArr[1]=arr[arr.length-1];
     
//      return LargeSmallArr;
//    }
// }
  /** Sorted or not **/ 
 
  /*    boolean result= isSorted(arr);
     if(result)
       System.out.println("Array is sorted");
     else
       System.out.println("Array is not sorted");
  }
   
    static boolean isSorted(int arr[]){
     for(int i=0;i<arr.length-1;i++){
        if(arr[i+1]<=arr[i])
          return false;
     }
     return true;
   }
  */
       
 /** count of number strictly greter than x ***/
  
   /* int count = greterThan(arr, x);
    System.out.println(count+" element strictly greter than "+x); 
  }
   
    static int greterThan(int arr[],int x){
     int count=0;
      for(int i=0;i<arr.length;i++){
        if(arr[i]>x)
          count++;
        }
     return count;
    }*/
    
 /** Last Occurrence of x number un array ***/
  /* 
    int lastindex = lastOccurance(arr,x);
    
     System.out.println("Last occurrence of "+x+" at index "+lastindex);
   }
    
    static int lastOccurance(int arr[],int x){
       int index=0;
       for(int i=0;i<arr.length;i++){
          if(arr[i]==x)
            index=i;
          }
        return index;
     }
   */
  
  /** count of any number in array **/
  /*  
    int count = getCount(arr, x);
    System.out.println(x+" is "+count+" times in given array");
   
   }
   static int getCount(int arr[],int x){
    int count=0;
     for(int i=0;i<arr.length;i++){
        if(arr[i]==x)
          count++;
        }
     return count;
    }
  */


  /*To Find Kth samllest and Mth largest Number in Array */

import java.util.*; 

  class Allarray{
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);    
        int n;
        System.out.println("Enter size of array: ");
        n=sc.nextInt();
        
        int[] arr= new int[n];
        System.out.println("Enter "+arr.length+" number of array with sapce: ");
          for(int i=0;i<arr.length;i++){
             arr[i]=sc.nextInt();
             }
       System.out.println("Enter the number of small number:");
       int k=sc.nextInt(); 
       System.out.println("Enter the number of large number:");
       int m=sc.nextInt();    

      getSmallLargethNumber(arr,k,m);
  
      }
    static void getSmallLargethNumber(int arr[],int k , int m){
      Arrays.sort(arr);  // Inbulit Or Predifined Method

      System.out.println("The "+k+"th smallest nuumber is "+arr[k-1]);
      System.out.println("The "+m+"th largestest nuumber is "+arr[arr.length-m]);
    }
  }

