package Sorting;
import java.nio.channels.NetworkChannel;

class SortingProb5{

     // PRINTING METHOD
   static void print(int arr[]){
    for(int i=0;i<arr.length;i++){
      System.out.print(arr[i]+" ");
    }
    System.out.println();
  }

/* Given an array of positive nad negative numbers , sepretes the nagive numbers inot left side and positive to right side. Do in linear time O(n).*/
    static void getSort(int[] arr){
      int n=arr.length;

      int i=0;
      int j=n-1;
      while (i<j) {
          while(arr[i]<0) i++;
          while (arr[j]>=0) j--;
          if(i<j){
              int temp=arr[i];
              arr[i]=arr[j];
              arr[j]=temp;
              i++;
              j--;
          }
      }

      // while (i<j) {
      //     if(arr[i]>=0 && arr[j]<0){
      //         int temp=arr[i];
      //         arr[i]=arr[j];
      //         arr[j]=temp;
      //         i++;
      //         j--;
      //     }else if(arr[i]>=0 && arr[j]>=0){
      //         j--;
      //     }else if(arr[i]<0 && arr[j]<0){
      //         i++;
      //     }else{
      //         i++;
      //         j--;
      //     }
      // }

      // int ans[] = new int[n];
      // int j=0;
      // int k=n-1;
      // for(int i=0;i<n;i++){
      //     if(arr[i]<0){
      //         ans[j++]=arr[i];
      //     }else{
      //         ans[k--]=arr[i];
      //     }
      // }
    }

    /*  Given an array of 0,1 and 2 sort it in asending order.*/
    static void getZeroOneTwo(int arr[]){
      
      int count1=0,count2=0,count0=0;
      for (int val:arr) {
        if(val==0){
          count0++;
        }else if(val==1){
          count1++;
        }else{
          count2++;
        }
      }
      int i=0;
      while (count0>0) {
        arr[i++]=0;
        count0--;
      }
      while (count1>0) {
        arr[i++]=1;
        count1--;
      }
      while (count2>0) {
        arr[i++]=2;
        count2--;
      }

    }

    static void getZeroOneTwoNew(int arr[]){

      int n=arr.length;
      int low=0,mid=0,hi=n-1;

      while (mid<=hi) {
        if(arr[mid]==0){
          int temp=arr[mid];
          arr[mid]=arr[low];
          arr[low]=temp;
          low++;
          mid++;
        }else if(mid==1){
          mid++;
        }else{
          int temp=arr[mid];
          arr[mid]=arr[hi];
          arr[hi]=temp;
          hi--;
        }
      }

    }
    public static void main(String[] args) {
        
        // int arr[]={8,0,7,-4,-13,11,-9,-8};
        // getSort(arr);
        // print(arr);

        int[]  arr={2,1,2,0,0};
       // getZeroOneTwo(arr);  // this fuction takes two pass 
       getZeroOneTwoNew(arr);
       print(arr);
        
    }
}