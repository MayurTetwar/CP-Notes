package Recursion;

public class Problem6Array {

    /* Print all elmennts of array recursivly */
    static void printArray(int[] arr,int k){

        if(k==arr.length){             // base case
            return;
        }
        System.err.print(arr[k]+" ");  // self work
        printArray(arr, k+1);          // recursion work
        return;
    }
    // n=arr.length;
    // Time Complexity = O(n)
    // Space Complexity = O(n)

    /* Print the max value in array. */
    static int getmax(int[] arr,int ind){
          
        if(ind==arr.length-1){         // base case
            return arr[ind];
        }
        int max=getmax(arr, ind+1);   // recursive work (bhai reursion tu baki numbers ka max la de me usko current element se compair kar dunga.)
        if(arr[ind]>max){             // self work
           max=arr[ind];
        }
        return max;
    }
    // n=arr.length;
    // Time Complexity = O(n)
    // Space Complexity = O(n)

    /* Find the sum of all elements of array. */
    static int getSum(int[] arr,int ind){

        if(ind==arr.length-1){      // Base case
            return arr[ind];    
        }
        return arr[ind]+getSum(arr, ind+1);  // self work+recursive work
    }
    // n=arr.length;
    // Time Complexity = O(n)
    // Space Complexity = O(n)

    public static void main(String[] args) {
        
        int[] arr={1,2,3,4,5};

        printArray(arr, 0);
        System.out.println();
        System.out.println("Max = "+getmax(arr, 0)); // Array should be not empty.
        System.out.println("Sum = "+getSum(arr, 0));
    }
}
