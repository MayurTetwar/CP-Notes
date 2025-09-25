package Sorting;
import java.util.*;


/* Sort the array , given array have only two value swap eith eah other only done code in o(n) TC. */
public class SortingProb4 {

    // PRINTING METHOD
    static void print(int arr[]){
       for(int i=0;i<arr.length;i++){
         System.out.print(arr[i]+" ");
        }
      System.out.println();
    }

  public static void main(String[] args) {

    int[] arr={};
    int n=arr.length;
    int x=-1;
    int y=-1;
    boolean flag=false;
    for(int i=0;i<n-1;i++){
       if(arr[i]>arr[i+1]){
          if(x==-1){
            x=i;
            y=i+1;
          }else{
            y=i+1;
          }
          flag=true;
       }
    }
  if(flag){
    int temp=arr[x];
    arr[x]=arr[y];
    arr[y]=temp;
   } 

    print(arr);
  } 
}
