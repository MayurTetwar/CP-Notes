package Searching;

public class UpAndLowerBond {
    public int lowerBound(int[] arr,int tar){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=(st+end)/2;
            if(arr[mid]<tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
    public int upperBound(int[] arr,int tar){
        int st=0;
        int end=arr.length;
        while(st<end){
            int mid=(st+end)/2;
            if(arr[mid]<=tar){
                st=mid+1;
            }else{
                end=mid;
            }
        }
        return st;
    }
}
