package Strings;

import java.util.*;

public class StringProblem {

    static boolean isPalindrome(String s){
        int i=0;
      int j=s.length()-1;
      while (i<j) {
          if(s.charAt(i)!=s.charAt(j)){
               return false;
            } 
            i++;
            j--;
      }
      return true;
    }
    static String removeAllconcicativeChar(String s){
         String ans="";

        for(int i=0;i<s.length();i++){
            if(i<s.length()-1){
                if(s.charAt(i)!=s.charAt(i+1)){
                    ans=ans+s.charAt(i);
                }
            }else{
                if(ans.charAt(ans.length()-1)!=s.charAt(i)){
                    ans=ans+s.charAt(i);
                }
            }
        }
        return ans;
    }

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        
      System.out.println("Enter the String: ");
      String s=sc.nextLine();  

      boolean ans=isPalindrome(s);
      if(ans){
        System.out.println("String is palindrome!");
        return;
      }else{
        System.out.println("String is not palindrome!");
        return;
      }
      
    //  String ans=removeAllconcicativeChar(s);
    //  System.out.println(ans);
    }
}
