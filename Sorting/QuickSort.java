package Sorting;

public class QuickSort {


     /* Printing method */
     static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    static int partition(int[] arr,int p,int r){

        int pivot=arr[r];
        int i=p-1;
        for(int j=p;j<r;j++){
            if(arr[j]<pivot){
                i++;
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        } 
        System.out.println();
        int temp=arr[i+1];
        arr[i+1]=arr[r];
        arr[r]=temp;
        return i+1;
    }

    static void quickSort(int[] arr,int p,int r){

        if(p<r){
            int q= partition(arr,p,r);
            quickSort(arr, p, q-1);
            quickSort(arr, q+1, r);
        }
    }

    public static void main(String[] args) {
     
        int[] arr={1,5,1,1,6,4};
        quickSort(arr, 0, arr.length-1);
        printArr(arr);
    }
}           
