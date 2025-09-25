package Strings;

import java.util.Scanner;

public class GetAllSubString {

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        
        String s=sc.nextLine();
        int n=s.length();
        for (int i = 0; i < n; i++) 
           for (int j = i+1; j <= n; j++)
                System.out.println(s.substring(i, j));

    }
}
