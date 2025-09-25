package Recursion;

import java.util.*;

public class Problem7Array {

    /* Print wheter target(x) is present in given array or not. */
    static boolean isPresent(int[] arr,int ind,int x){

        if(ind==arr.length){       // base work
            return false;
        }
        if(arr[ind]==x){           // self work 
            return true;
        }
        return isPresent(arr, ind+1, x);  // Recursive work
    }
    // n=arr.length;
    // Time Complexity = O(n)
    // Space Complexity = O(n)

    /* Return index of target if present other wise return -1. */
    // here we get only first index of target
    static int getTargetInd(int[] arr,int ind,int x){

        if(ind==arr.length){       // base work
            return -1;
        }
        if(arr[ind]==x){           // self work 
            return ind;
        }
        return getTargetInd(arr, ind+1, x);  // Recursive work
    }

    /* Print all index of target in array.(Return type void) */
    static void getAllInd(int[] arr,int ind,int x){
    
        if(ind==arr.length){       // base work
            return;
        }
        if(arr[ind]==x){           // self work 
            System.out.print(ind+" ");
        }
        getAllInd(arr, ind+1, x);  // Recursive work
    }

    /* Return an ArrayList which conatain all index of target in array. */
    static ArrayList<Integer> getAllIndInAL(int arr[],int n,int target,int ind){

        if(ind>=n){                  // base work
         return new ArrayList<>();    // Return empty arrayList   
        }
        
        ArrayList<Integer> arrList = new ArrayList<>();
        if(arr[ind]==target){       //self work
            arrList.add(ind);
        }
        ArrayList<Integer> smallAns = getAllIndInAL(arr, n, target,ind+1);  // Recursive work
        arrList.addAll(smallAns);

        return arrList;
    }   
        public static void main(String[] args) {
        
        int[] arr={1,4,2,4,2,6};

        /* Function 1 */
        // boolean ans=isPresent(arr, 0,4);
        // if(ans) System.out.println("YES");
        // else System.out.println("NO");

         /* Function 2 */
//System.out.println("Index = "+getTargetInd(arr, 0, 4));
       
         /* Function 3 */
        // getAllInd(arr, 0, 2);

       System.out.println();
        
        /* Function 4 */
      // ArrayList<Integer> arrList=getAllIndInAL(arr, arr.length, 2, 0);
      // System.out.println(arrList);

      /* Function 5 */
    //   boolean result=isSorted(arr, arr.length, 0);
    //   if(result) System.out.println("YES");
    //   else System.out.println("NO");

     /*  Function 6 */
     System.out.println(getLastInd(arr, arr.length, 0, 4));
     
    }

    /* Return Yes if array is sorted otherwise No. */
    static boolean isSorted(int arr[],int n,int ind){

       if(ind==n-1){           // base case
        return true;
       }
       if(arr[ind]>arr[ind+1]){      // self work
        return false;
       }
       return isSorted(arr, n, ind+1); // recursion work
    }

    /* Return last index of target in array. */
    static int getLastInd(int arr[],int n,int ind,int target){

        int max=-1;
        if(ind>=n){           // base case
            return max;
        }
        if(arr[ind]==target){   // self work
            max=ind;
        }
        int smallAns= getLastInd(arr, n, ind+1, target);  // recursion work
        if(max<smallAns){ 
            return smallAns;
        }else{
            return max;
        }
    }
}
