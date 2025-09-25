package Concepts;
import java.util.*;


public class AllInput {
    public static void main(String args[]){ 
    
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Name:");
        String name=sc.nextLine();
        System.out.print("Enter Roll No.:");
        int roll=sc.nextInt();
        System.out.print("Enter percentage:");
        double per=sc.nextDouble();
        System.out.println( 
              "Your name: "+name
              +"\nRoll No.: "+roll
              +"\nPercentage: "+per
            );
        sc.close();
    }
}
