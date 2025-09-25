package Recursion;

import java.util.*;

public class Problem5GCD {

    // Brute Force method //
    static int gcd(int x,int y){

        int gcdNum=0;
        for(int i=y;i>0;i--){
            if(x%i==0 && y%i==0){
                gcdNum=i;
                break;
            }
        }
        return gcdNum;
    }
    // Time Complexity = O(min(x,y)) , Here O(y)

    // Best Code //
    static int gcd2(int x,int y){

        if(y==0){
            return x;
        }
        return gcd2(y,x%y);
    }
    //
    public static void main(String[] args) {
        
       Scanner sc = new Scanner(System.in);

       int x=sc.nextInt();
       int y=sc.nextInt();

       System.out.println("GCD = "+gcd(x, y));
       int g=gcd2(x, y);
       System.out.println("GCD2 = "+g);

       int lcm=(x*y)/g; // Formula to calculate lcm from gcd.
       System.out.println("LCM = "+lcm);

    }
}
