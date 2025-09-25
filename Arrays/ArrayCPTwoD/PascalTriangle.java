package ArrayCPTwoD;

import java.util.*;
public class PascalTriangle {

    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        
        int n;
        System.out.println("Enter the number of rows : ");
        n=sc.nextInt();

        int[][] arr=new int[n][];

        arr=getPascalTriangle(arr);
        printTriangle(arr);
    }

    static int[][] getPascalTriangle(int[][] arr){

        int n=arr.length;
        for(int i=0;i<n;i++){
            //ith row has i+1 columns
            // arr[i]=new int[i+1];
            // for(int j=0;j<i+1;j++){

            //    if(j==0 || j==i){    // First and last element in every row is 1
            //     arr[i][j]=1;
            //    }else{
            //     arr[i][j]=arr[i-1][j]+arr[i-1][j-1];   // Central elements 
            // }
             
            //   OR   //

            //ith row has i+1 columns
             arr[i]=new int[i+1];
             arr[i][0]=arr[i][i]=1;   // First and last element in every row is 1
            
             for(int j=1;j<i;j++){
                arr[i][j]=arr[i-1][j]+arr[i-1][j-1];   
             }
        }
        return arr;
    }

    static void printTriangle(int[][] arr){

        int n=arr.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n-1-i;j++){
                System.out.print(" ");
            }
            for(int j=0;j<=i;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}
