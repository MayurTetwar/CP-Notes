package ArrayCPTwoD;

import java.util.*;

public class Matrixadd {

    static Scanner sc=new Scanner(System.in);

    public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix1 : ");
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int[][] arr= new int[r1][c1];
        System.out.println("Enter "+ r1*c1 +" element in matrix 1 :");
        takeInputArray(arr);

        System.out.println("Enter number of rows and columns of matrix2 : ");
        int r2=sc.nextInt();
        int c2=sc.nextInt();
        int[][] arr2= new int[r2][c2];
        System.out.println("Enter "+ r2*c2 +" element in matrix 1 :");
        takeInputArray(arr2);

        addMatrix(arr, r1, c1, arr2, r2, c2);
    }

    static void addMatrix(int arr[][],int r1,int c1,int arr2[][],int r2,int c2){

       int[][] sum=new int[r1][c1];
       if(r1!=r2 || c1!=c2){
        System.out.println("Invalid input please enter same number of rows and columns in both matrix !");
        return;
       }else{
        for(int i=0;i<r1;i++){
            for(int j=0;j<c1;j++){
              sum[i][j]= arr[i][j]+arr2[i][j];          
            }
         }
       }
       System.out.println("Sum of matrix1 and matrix2 :");
       Arrays.printArray(sum);
    }

    static void takeInputArray(int[][] arr){
      
      for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[i].length;j++){
           arr[i][j]= sc.nextInt();           
         }
      }
   }

}
