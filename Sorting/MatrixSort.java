package Sorting;
import java.util.*;

public class MatrixSort {
    public static void main(String[] args) {
        
        int[][] arr={{2,3},{5,6},{1,3},{-1,8}};
        int n=arr.length;
        int m=arr[0].length;
        Arrays.sort(arr,(a,b)->Integer.compare(a[0],b[0]));
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}

