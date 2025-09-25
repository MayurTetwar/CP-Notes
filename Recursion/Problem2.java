package Recursion;

import java.util.*;

public class Problem2 {

    /* To find factorial of number using Recursion. */

    static int factorial(int n){
        if(n==0){
            return 1;
        }
        return factorial(n-1)*n;
    }
    // Time Complexity = No. of recursive calls * Time taken by each recursive fuction
    // Time Complexity = (n+1) * c(similar or constant time reqauired by each fuction)
    // Time Complexity = nc ~ n
    // Time Complexity is O(n)
    // Space Complexity is the total number of stack frames in call stack * space occupies in each stack frame.
    // Space Complexity = n * 1(stack frame not take any sapce)
    // Space Complexity = O(n)

    /* To find nth fibonacci number using Recursion.*/

    static int fibonacciNo(int n){

        if(n==0 || n==1){
            return n;
        }
        return fibonacciNo(n-1)+fibonacciNo(n-2);
    }
    // Breft solution present in notes.
    // Time Complexity = O(2^n)
    // Space Complexity = O(n)
       public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        int n=sc.nextInt();

        System.out.println(factorial(n));
        System.out.println(fibonacciNo(n));
    }
}
