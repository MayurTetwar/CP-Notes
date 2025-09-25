package Recursion;

import java.util.*;

public class AllpermutaionOfArray {

    static void generatePermutation(int[] arr, int start, int end) {
        if (start == end - 1) {
            System.out.println(Arrays.toString(arr));
        } else {
            
            for (int i = start; i < end; i++) {
                swapNumber(arr,start,i);
                generatePermutation(arr, start + 1, end);
                swapNumber(arr,start,i);
            }
        }
    }

    public static void swapNumber(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {

        int[] arr={1,2,3};
        int len = arr.length;
        generatePermutation(arr, 0, len);
    }
}
