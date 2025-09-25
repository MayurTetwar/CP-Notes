package ArrayCPTwoD;

import java.util.*;

public class MatrixTranspose {

    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix : ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr= new int[r][c];
        System.out.println("Enter "+ r*c +" element in matrix :");
        takeInputArray(arr);

        System.out.println("Transpose Matrix is :");
      //   arr=getTranspose(arr, r, c);
        getTransposeInPlace(arr, r, c);
        Arrays.printArray(arr);
        
    }

    static void getTransposeInPlace(int arr[][],int r,int c){

      for(int i=0;i<r;i++){
         for(int j=i;j<c;j++){    // Traversing Orignal array
            int temp=arr[i][j];
            arr[i][j]=arr[j][i];
            arr[j][i]=temp;
         }
      }
    }
    static int[][] getTranspose(int arr[][],int r ,int c){
        
      int[][] ans=new int[c][r];  // Using Another Array
      int i,j;
      for(i=0;i<c;i++){
        for(j=0;j<r;j++){
           ans[i][j]=arr[j][i];
        }
      }
      return ans;
   }

   static void takeInputArray(int[][] arr){
      
      for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[i].length;j++){
           arr[i][j]= sc.nextInt();           
         }
      }
   }
}
