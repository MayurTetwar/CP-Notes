package Concepts;


public class Swaping {
    public static void main(String[] args) {
        int a=3;
        int b=9;
       
        System.err.println("Original Values Are :");
        System.err.println("a: "+a+" b: "+b);
        // // Method 1
        // int temp=a;
        //      a=b;
        //      b=temp;
        
        // Method 2
        a=a+b;
        b=a-b;
        a=a-b;

         System.err.println("After Swap Values Are :");
         System.err.println("a: "+a+" b: "+b);
    }
}
