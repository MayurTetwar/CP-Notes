package ArrayCPTwoD;

import java.util.Scanner;

public class Matrixmul {
    
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
        System.out.println("Enter "+ r2*c2 +" element in matrix 2 :");
        takeInputArray(arr2);

        mulMatrix(arr, r1, c1, arr2, r2, c2);
    }

    static void takeInputArray(int[][] arr){
      
        for(int i=0;i<arr.length;i++){
           for(int j=0;j<arr[i].length;j++){
             arr[i][j]= sc.nextInt();           
           }
        }
     }

     static void mulMatrix(int [][]arr,int r1,int c1,int arr2[][],int r2,int c2){
     
        int[][] mul=new int[r1][c2];

        if(c1 != r2){
            System.out.println("Invalid input! , matrix1 columns must eqaul to matrix2 rows");
            return;
           }else{
            for(int i=0;i<r1;i++){
                for(int j=0;j<c2;j++){
                    for(int k=0;k<c1;k++){
                        mul[i][j]+= (arr[i][k]*arr2[k][j]);    
                    }
                }
             }
           }
           System.out.println("Multiplication of matrix1 and matrix2 :");
           printArray(mul,r1,c2);    
     }

     static void printArray(int arr[][],int r,int c){
       
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
             System.out.print(arr[i][j]+"  ");  // Prenting array
            }
            System.out.println( );
         }  
    }
}
