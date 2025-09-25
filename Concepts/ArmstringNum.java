package Concepts;

import java.util.*;

/* To find all n digit armstrong number .*/

public class ArmstringNum {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter numbers of digit in number:");
        int n=sc.nextInt();

        long i=(long)Math.pow(10, n-1);
        while(i<=(long)Math.pow(10, n)-1){
             
            long num=i,sum=0;
            while (num>0) {
                long digit=num%10;
                sum+=(long)Math.pow(digit, n);
                num/=10;
            }
            if(i==sum){
                System.out.print(i+" ");
            }
            i++;
        }
        sc.close();
    }
}
