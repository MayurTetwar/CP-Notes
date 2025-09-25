package Recursion;

import java.util.*;

public class Problem9SubSequance {

    /* Given an String ,return all the subsequance in ArrayList of a String. */
    /* Subsequance is all posible combination of charcter in String eith chinging order. */
    static ArrayList<String> getSS(String str){

        ArrayList<String> ans=new ArrayList<>();
        if(str.length()==0){            // base case
            ans.add(" ");
            return ans;
        }

       char curr = str.charAt(0);
       ArrayList<String> smallAns=getSS(str.substring(1)); // recursive work
       for (String ss : smallAns) {         // self work
           ans.add(ss);
           ans.add(curr+ss);
        }
      return ans;
    }
    // Scpce complexity ~O(2^n)--(As 2^k is combination of all character in string.)

    /* Print all subsequance of given String. */
    static void getSubStr(String s,String ans){

        if(s.length()==0){              // base case
            System.out.println(ans);
            return;
        }

        char curr=s.charAt(0);   // get first char
        String currStr=s.substring(1);  // take string without first char
        getSubStr(currStr,ans+curr); // add curr char in ans
        getSubStr(currStr, ans);// not add curr char in ans
    }
    // Space Complexity = No. of maximum Stack frame in Call Stack * size occupies by each stack frame 
    // SC = (n+1)* (~n)(here n for method using of string)
    // SC= O(n^2)

    /* Given an array of integer , print all nums of subsets in it. output sums can be printed in any order. */
    static void getSubArr(int[] arr,int ans,int ind){

        if(arr.length==ind){              // base case
            System.out.println(ans);
            return;
        }
        getSubArr(arr, ans+arr[ind],ind+1);  // with ind index value
        getSubArr(arr, ans,ind+1);       // without ind index value
    }

    public static void main(String[] args) {
    
    //   ArrayList<String> ans=getSS("bac");
    //   System.out.println(ans);

    // getSubStr("abc", " ");

      int[] arr={2,4,5};
      getSubArr(arr, 0,0);
    } 
}
