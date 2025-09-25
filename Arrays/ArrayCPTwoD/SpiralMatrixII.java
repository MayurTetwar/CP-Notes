package ArrayCPTwoD;

import java.util.*;
public class SpiralMatrixII {

    static Scanner sc= new Scanner(System.in);
    public static void main(String[] args) {
        
        int n;
        System.out.println("Enter the order of matrix : ");
        n=sc.nextInt();

        int arr[][] = getSpiralMatrix(n);
        Arrays.printArray(arr);
    }

    static int[][] getSpiralMatrix(int n){
        
        int element=1;
        int arr[][] = new int[n][n];
        int topRow = 0, bottomRow = n - 1, leftCol = 0, rightCol = n - 1;
        while (element<=n*n) {
            
            for (int i = leftCol; i <= rightCol && element<= n*n; i++) {
                arr[topRow][i]=element;
                 element++;
             }
             topRow++; 
             for (int i = topRow; i <= bottomRow && element<= n*n; i++) {
                 arr[i][rightCol]=element;
                 element++;
              }
             rightCol--;  

             for (int i = rightCol; i >= leftCol && element<= n*n; i--) {
                 arr[bottomRow][i]=element;
                 element++;
             }
              bottomRow--;

             for (int i = bottomRow; i >= topRow && element<= n*n; i--) {
                  arr[i][leftCol]=element;
                  element++;
              }
             leftCol++;
        }
        return arr;
    }
}
