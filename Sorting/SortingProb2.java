package Sorting;
import java.util.*;

public class SortingProb2 {

    /* Sort an String array in lexicographical orrder using selection sort. */
    public static void main(String[] args) {
        
      String[] arr={"papaya","lime","eatermelon","apple","mango","kiwi"};
      int n=arr.length;

        for(int i=0;i<n-1;i++){
            int minInd=i;
            for(int j=i+1;j<n;j++){
                if(arr[j].compareToIgnoreCase(arr[minInd])<0){ // return negative value when arr[minInd] is less tahn arr[i] that is current index.
                    minInd=j;
                }
            String str=arr[i];
            arr[i]=arr[minInd];
            arr[minInd]=str;
            }
        }
        for (String s : arr) {
            System.out.println(s+" ");
        }

    }
}
