package Recursion;

import java.util.*;

public class Problem1 {
     /* Print from 1 to n */
    static void getNnumber(int n){
        if(n==1){
           System.out.println(1);
           return ;
        }
        getNnumber(n-1);
        System.out.println(n);
    }
     /* Print from n to 1 */
    static void getNnumber2(int n){
       
       if(n==0){
        return;
       }
       System.out.println(n);
       getNnumber2(n-1);
    }
    public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        int n=sc.nextInt();

        getNnumber2(n);
    }
}
