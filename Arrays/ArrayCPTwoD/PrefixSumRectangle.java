package ArrayCPTwoD;

import java.util.*;

/* Given a matrix 'a' of dimension n x m and 2 coordinates (l1, r1) and (l2, r2).
    Return the sum of the rectangle from (l1,r1) to (l2, r2). */
  
// Method-3 is Best //

public class PrefixSumRectangle {

    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
        
        System.out.println("Enter number of rows and columns of matrix : ");
        int r=sc.nextInt();
        int c=sc.nextInt();
        int[][] arr= new int[r][c];
        System.out.println("Enter "+ r*c +" element in matrix :");
        takeInputArray(arr);

        System.out.println("Enter rectangle starting co-ordinate(l1,r1) and Ending co-ordinates(l2 ,r2) : ");
        int l1=sc.nextInt();
        int r1=sc.nextInt();
        int l2=sc.nextInt();
        int r2=sc.nextInt();

        int sum=0;
        if(l1<=l2 && r1<=r2 ){
            if(0<=l1 && l2<r && 0<=r1 && r2<c){

                 sum=getRectanglesumBFM(arr, l1, r1, l2, r2); // (Method-1)
                 System.out.println("The sum of rectangle is :"+sum);
            
                 // To get prefixSumRow of Matrix  
                  getPrefixSumArrayInRow( arr, r, c);  
                 // Arrays.printArray(arr);
                 sum=getRectanglesumPS(arr, l1, r1, l2, r2); // (method-2)
                 System.out.println("The sum of rectangle is :"+sum);
                 
                 // TO get prefixSumCol of Matrix 
                 getPrefixSumArrayInCol(arr, r, c);
                 sum=getRectanglesumPSRC(arr,l1,r1,l2,r2);  // (method-3)
                 System.out.println("The sum of rectangle is :"+sum);

            }else{
             System.out.println("Invalid co-ordinate ! plz check again.");
             return;
            }
        }else{
            System.out.println("Invlid co-ordinate! Start co-ordinate must be less than end co-ordinate.");
            return;
        }
    }

    // Method 1 => Brute Force method (Bot method) //
    static int getRectanglesumBFM(int arr[][],int l1,int r1,int l2,int r2){
        int sum=0;
        for(int i=l1;i<=l2;i++){           // Time complexcity(l2*r2*query) Ex., 3*3*3=81
            for(int j=r1;j<=r2;j++){
                sum+=arr[i][j];
            }
        }
        return sum;
    }

    // Method 2 => Pre-Calculation the horizontal sum for each row in the matrix.(pro method) //
    // This method usefull for multiple queries
    static int getRectanglesumPS(int arr[][],int l1,int r1,int l2,int r2){
        int sum=0;
        for(int i=l1;i<=l2;i++){       // Here, we use only one loop and not traverse all element 
            if(r1==0){                 // Time complexcity((l2*r2)+(query*row)) 
                sum+=arr[i][r2];       // Ex., (3*3)(only one time traverse for prefixsum)+query*rows 
            }else{                     // 3*3+3*3=18
                sum=sum+arr[i][r2]-arr[i][r1-1];
             }
        }
        return sum;
    }
    static void getPrefixSumArrayInRow(int [][]arr,int r, int c){
        for(int i=0;i<r;i++){
            for(int j=1;j<c;j++){
               arr[i][j]+=arr[i][j-1];
              }
        }
    }

    // Method-3 => PrefixSum Over Columns and Rows Both (legend method)//
    // After taking prefixSum of Arrays in rows wise , Take PrefixSum in Columns wise
    static void getPrefixSumArrayInCol(int [][]arr,int r,int c){
        for(int i=1;i<c;i++){
            for(int j=0;j<r;j++){
                arr[i][j]+=arr[i-1][j];
            }
        }
    }
    // In this method , We take prefix at row and col on both side
    // Due to this at any index value is must be sum of all value in rectangle from 0,0 index
    // Time Complexcity => (r*c for prefixSumRow)+(r*c for prefixSumCol) 
    // Ex. 3*3+3=12
    // Best TimeComplexCity Code
    static int getRectanglesumPSRC(int arr[][],int l1,int r1,int l2,int r2){
    
      if(l1==0 && r1==0){       
        return arr[l2][r2];
      }else if(l1==0){
        return arr[l2][r2]-arr[l2][r1-1];
      }else if(r1==0){
        return arr[l2][r2]-arr[l1-1][r2];
      }else{
        return arr[l2][r2]-arr[l2][r1-1]-arr[l1-1][r2]+arr[l1-1][r1-1];
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
