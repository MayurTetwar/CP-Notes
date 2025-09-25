package Recursion;

import java.util.*;

class Problem8String{

    /* Remove all ocurance of 'a' in String. */
    static String removeA(String str,int ind){

        if(str.length()<=ind){   // base case
            return "";
        }

        String retStr=removeA(str, ind+1);  // recursive work
        char c=str.charAt(ind);     // self work
        if(c!='a') return c+retStr;  //->A
        else return retStr;
    }
    // Time Complexity = No. of recursive calls * Time taken in 1 call
    // TC= (n)*(n+c)
    // where 1st n is length of string and
    // next (n+c) is for Line A ,Here two String are concatinate so it requaired O(n) time (Linear Time) not constant time. 
    // So, TC = O(n*n) = O(n^2)

    /* Remove all ocurance of 'a' in String with changing string */
   static String remoeA2(String str){

      if(str.length()==0){
        return "";
      }
      String retStr = remoeA2(str.substring(1)); // This substring method is linear time ~O(n)
      char c=str.charAt(0);
      if(c!='a') return c+retStr;
      else return retStr;
    }
    //Time Complexity = n * (n (concatination) + n(substring) * c)
    // TC = O(n*(2n))
    // TC = O(n^2)

    /* Print the reverse of string .*/
    static String reverseStr(String str,int ind){

        if(str.length()==ind){
            return "";     // base case
        }
        String s = reverseStr(str, ind+1) + str.charAt(ind);   // Recurcive work + Self work 
        return s;
    }
    // Time Complexity = O(n^2)

    /* Cheak given string is polindrome or not. */
    static boolean isPolindrome(String str,int last,int start){

        if(start>=last){     // base case
            return true;
        }
        if(str.charAt(start)!=str.charAt(last)){  // self work 
            return false;
        }else{
            return isPolindrome(str, last-1, start+1);  // recursive work
        }
        /* ----------OR---------- */
    //     if(last<=start) return true;
    //     return (str.charAt(start)==str.charAt(last) && isPolindrome(str, last-1, start+1));
    }
    // Time Complexity = O(n) = No. of recursive calls(n) * time taken by 1 call(c)

    public static void main(String[] args) {
        
         Scanner sc = new Scanner(System.in);
        // String str = sc.next(); // It is read only one String i.e. after space it is not read
         String s=sc.nextLine(); // Take a full line as String
        // String s="Mayur Tetwar";
        // String subSt = s.substring(2,9);
        // System.out.println(subSt);  // yur Tet

        //  System.out.println(removeA(s, 0));
        //  System.out.println(remoeA2(s));

       //  System.out.println(reverseStr(s, 0));
       boolean ans=isPolindrome(s, s.length()-1, 0);
       if(ans)
       System.out.println("String is polindrome.");
       else
       System.out.println("String is not polindrome.");

    }
}