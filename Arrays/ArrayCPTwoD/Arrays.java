package ArrayCPTwoD;

import java.util.*;

public class Arrays {
     public static void main(String[] args) {
        
        Scanner sc=new Scanner(System.in);

        System.out.println("Enter number of rows : ");
        int m=sc.nextInt();
        System.out.println("Enter number of columns : ");
        int n=sc.nextInt();
     
        int[][] arr= new int[m][n];

         
        System.out.println("Enter "+(m*n)+" numbers {}");
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[i].length;j++){
             arr[i][j]= sc.nextInt();           // Taking input in 2D Array using 
           }
        }
        printArray(arr);
     }
    static void printArray(int arr[][]){
       
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
             System.out.print(arr[i][j]+" ");  // Prenting array
            }
            System.out.println( );
         }  
    }
    
}