package ArrayCPTwoD;

import java.util.*;
/*
 Given an n*m matrix 'a', return all elelment of the matrix in spiral order.
 */
public class SpiralMatrix {

    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix : ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr= new int[r][c];
        System.out.println("Enter "+ r*c +" element in matrix :");
        takeInputArray(arr);

       getSpiralOrder(arr,r,c);
       System.out.println();
       myspiral(arr, r, c);
    }
   
    // My written code have not readability and efficient //
    
   //  static void getSpiralOrder(int arr[][],int r,int c){

   //   int i=0,j=0,k=0;
   //   int totalElement=0,n=c*r;
   //    while(totalElement<=n){
   //         while(j<c-i){
   //            totalElement++;
   //            if(totalElement<=n)
   //            System.out.print(arr[k][j]+" ");
   //            j++;
   //           }
   //           j--;
   //         while(++k<r-i){
   //            totalElement++;
   //            if(totalElement<=n)
   //            System.out.print(arr[k][j]+" ");
   //           }
   //           k--;
   //         while(--j>=i){
   //            totalElement++;
   //            if(totalElement<=n)
   //            System.out.print(arr[k][j]+" ");
   //           } 
   //           j++;
   //         while(--k>i){
   //            totalElement++;
   //            if(totalElement<=n)
   //            System.out.print(arr[k][j]+" ");
   //           }
   //           i++;
   //           j++;
   //           k++;
   //      }
   //  }

   //  Best Code is Below //
    static void getSpiralOrder(int arr[][],int r,int c) {
        
         int topRow = 0, bottomRow = r - 1, leftCol = 0, rightCol = c - 1;
         int totalElement=0;

        while (totalElement< r*c) {
        // Print topRow (leftcol to rightcol)
        for (int i = leftCol; i <= rightCol && totalElement< r*c; i++) {
            System.out.print(arr[topRow][i] + " ");
            totalElement++;
        }
        topRow++;  // To take second row

        // Print rightCol (topRow to bottomRow)
        for (int i = topRow; i <= bottomRow && totalElement< r*c; i++) {
            System.out.print(arr[i][rightCol] + " ");
            totalElement++;
         }
        rightCol--;  

        // Print bottomRow (rightCol to leftCol)
            for (int i = rightCol; i >= leftCol && totalElement< r*c; i--) {
                System.out.print(arr[bottomRow][i] + " ");
                totalElement++;
            }
            bottomRow--;

        // Print leftColumn (bottomRow to topRow)
            for (int i = bottomRow; i >= topRow && totalElement< r*c; i--) {
                System.out.print(arr[i][leftCol] + " ");
                totalElement++;
            }
            leftCol++;
      }
    }

    static void takeInputArray(int[][] arr){
      
      for(int i=0;i<arr.length;i++){
         for(int j=0;j<arr[i].length;j++){
           arr[i][j]= sc.nextInt();           
         }
      }
  }    
     // Practice //
  static void myspiral(int arr[][],int r,int c){
   
   int topRow=0,bottomRow=r-1,leftCol=0,rightCol=c-1;
   int totalElement=0;

   while(totalElement<r*c){

      for(int i=leftCol;i<=rightCol && totalElement<r*c;i++){
         System.out.print(arr[topRow][i]+" ");
         totalElement++;
      }
      topRow++;
      for(int i=topRow;i<=bottomRow && totalElement<r*c;i++){
         System.out.print(arr[i][rightCol]+" ");
         totalElement++;
      }
      rightCol--;
      for(int i=rightCol;i>=leftCol && totalElement<r*c;i--){
         System.out.print(arr[bottomRow][i]+" ");
         totalElement++;
      }
      bottomRow--;
      for(int i=bottomRow;i>=topRow && totalElement<r*c;i--){
         System.out.print(arr[i][leftCol]+" ");
         totalElement++;
      }
      leftCol++;
   }
  }
}  

 
