package Sorting;


class SortingProb1{
    
    /* Given an array of integer , move all 0's to right side of array  without changing relative order od other non-zero numbers.*/
    public static void main(String[] args){

        int[] arr={0,5,0,3,42};
        int n=arr.length;
        
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-1-i;j++){
                if(arr[j]==0 && arr[j+1]==0){
                    int temp=arr[j+1];
                    arr[j+1]=arr[j];
                    arr[j]=temp;
                }
            }
        }
        for (int i : arr) {
            System.out.println(i);
        }
    }
}