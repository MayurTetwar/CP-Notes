package Recursion;

import java.util.*;

class Problem3{

    /* Find out sum of digits of a number. */
    static int sumOfDigits(int n){
        
        if(n>=0 && n<=9)   return n;   

        return sumOfDigits(n/10)+(n%10);  
    }
    // Time Complexity = O(d)
    // Space Complexity = O(d)
    // d is numbers of digits.

    /* Find numbers of digits of a number. */
    static int nosOfDigits(int n,int count){
      
        if(n<=0) return count;

        count++;
        return nosOfDigits(n/10, count);
    }
    /* Find p^q using recursion. */
    static int pow(int p,int q){
   
        if(q==0)  return 1;

        return p*pow(p, q-1);
    }
    // Time Complexity = O(q)
    // Space Complexity = O(q)

    static double pow2(double p,int q){

        if(q == 1) return p;
        if(q < 0) return 1.0/pow2(p, -q);
        double smallPow=pow2(p, q/2);
        
        if(q%2==0) 
        return smallPow*smallPow;
        else 
        return p*smallPow*smallPow;      
        // if(q == 0) return 1;
        // if(q < 0) return 1.0/pow2(p, -q);
        
        // if(q%2==0) 
        // return pow2(p*p, q/2);
        // else 
        // return p*pow2(p*p, q/2);    
    }
    // Time Complexity = O(log(q))
    // Space Complexity = O(log(q)) 

    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        // int n=sc.nextInt();
        // System.out.println(sumOfDigits(n));
        // System.out.println(nosOfDigits(n, 0));
  
        System.out.println("Enter base:");
        double p=sc.nextInt();
        System.out.println("Enter power:");
        int q=sc.nextInt();

        System.out.println("Answer: "+pow2(p, q));
    }
}