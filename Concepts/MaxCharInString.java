package Concepts;


import java.util.*;

public class MaxCharInString {

    public static void main(String[] args) {
     
      Scanner sc= new Scanner(System.in);

      String s=sc.nextLine();
      String str=s.toLowerCase();

      int[] arr=new int[str.length()];
      for(int i=0;i<str.length();i++){
         for(int j=i+1;j<str.length();j++){
            if(str.charAt(i)==str.charAt(j)){
                arr[i]++;
            }
         }
      }
      int max=-1;
      int ind=-1;
      for(int i=0;i<arr.length;i++){
        if(max<arr[i]){
            max=arr[i];
            ind=i;
        }
      }
      System.out.println(s.charAt(ind));
      sc.close();
    }       
}   