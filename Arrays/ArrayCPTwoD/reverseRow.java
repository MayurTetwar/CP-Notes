package ArrayCPTwoD;

import java.util.*;

public class reverseRow {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix : ");
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int[][] arr= new int[r1][c1];
        System.out.println("Enter "+ r1*c1 +" element in matrix :");
        takeInputArray(arr);

        System.out.println("Reverse rows matrix is :");
        reverseRowMatrix(arr, r1, c1);
        Arrays.printArray(arr);
    }

    static void reverseRowMatrix(int arr[][],int r1,int c1){
      
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1/2;j++){
                int temp= arr[i][j];
                arr[i][j]=arr[i][c1-1-j];
                arr[i][c1-1-j]=temp;
            }
        }
    }
    static void takeInputArray(int[][] arr){
      
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[i].length;j++){
             arr[i][j]= sc.nextInt();           
           }
        }
     }
}
