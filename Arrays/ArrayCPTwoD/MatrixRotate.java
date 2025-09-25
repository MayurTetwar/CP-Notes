package ArrayCPTwoD;

/* Given a square matrix, turn it iby 90 degrees in a clockwise direction without using 
    any extra space. */
import java.util.*;

public class MatrixRotate {

    static Scanner sc=new Scanner(System.in);
     public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix : ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr= new int[r][c];
        System.out.println("Enter "+ r*c +" element in matrix :");
        takeInputArray(arr);
        rotateMatrix(arr, r, c);
   
        System.out.println("Rotate Matrix is :");
        Arrays.printArray(arr);
     }

     static void rotateMatrix(int arr[][],int r,int c){

        MatrixTranspose.getTransposeInPlace(arr, r, c);

        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c/2;j++){
        //         int temp=arr[i][j];
        //         arr[i][j]=arr[i][c-1-j];
        //         arr[i][c-1-j]=temp;
        //     }
        // }

        //   OR
        reverseRow.reverseRowMatrix(arr, r, c);

        //   OR
        // Pass each array(row) in reverse Array method which reverse array
     }
     static void takeInputArray(int[][] arr){
      
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[i].length;j++){
             arr[i][j]= sc.nextInt();           
           }
        }
     }
}