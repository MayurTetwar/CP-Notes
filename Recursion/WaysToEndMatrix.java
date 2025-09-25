package Recursion;
import java.util.*;

public class WaysToEndMatrix {

    /* Numbers of ways to reach at end of matrix from starting index. */
    static int getSequance(int[][] arr,int row,int col){

        if(row==arr.length-1 && col==arr[0].length-1){
            return 1;
        }else if(row>=arr.length-1){
            return 1;
        }else if(col>=arr[0].length-1){
            return 1;
        }

        int ans = getSequance(arr, row+1, col);     
        int ans2 = getSequance(arr, row, col+1);
    
        return ans+ans2;
    }
   
    public static void main(String[] args) {
       
     int[][] arr={{1,2,9},{9,0,0},{5,9,6}};

      System.out.println(getSequance(arr, 0, 0));
    }
}
