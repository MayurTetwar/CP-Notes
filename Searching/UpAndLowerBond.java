package Searching;

public class UpAndLowerBond {
    public static int lowerBound(int[] arr,int tar){
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
    public static int upperBound(int[] arr,int tar){
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
    public static void main(String[] args) {
        System.out.println(lowerBound(new int[]{1,5},1));
    }
}
