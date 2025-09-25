package Searching;

class arr2DSearching {

   /* Based on if linearly incresing array element. */
   static boolean serachIn2Darr(int[][] arr,int target){
      

      /* Method 1 . finding row using binary serach them find target in col wise. */
      // int i=0;
      // int j=arr[0].length-1;
      // for(i=0;i<arr.length;i++){
      //    if(arr[i][j]==target){
      //      return true;
      //    }else if(arr[i][j]>target){
      //      break;
      //    }
      // }
      // if(i==arr.length){
      //    return false;
      // }
      // int start=0;
      // int end=arr[i].length-1;
      // while (start<=end) {
      //     int mid=(start+end)/2;
      //     if(arr[i][mid]==target){
      //         return true;
      //     }else if(arr[i][mid]>target){
      //         end=mid-1;
      //     }else{
      //         start=mid+1;
      //     }     
      // }
      // return false;
      
      /* Method 2. take first element and last element in matrix and do binart search on this. */
      int start=0;
      int n=arr.length;
      int m=arr[0].length;
      int end=n*m-1;

      while (start<=end) {
         int mid=start+(end-start)/2;
         if(target==arr[mid/m][mid%m]){
            return true;
         }else if(target<arr[mid/m][mid%m]){
            end=mid-1;
         }else{
            start=mid+1;
         }
      }
      return false;
   }

   /* based on first element is not grether than last elemnt of previous row. */
   static boolean searchMatrix(int[][] arr, int target) {
      
      int i=0;
      int j=arr[0].length-1;
      int n=arr.length;
      while(i<n && j>=0){
         if(arr[i][j]==target){
            return true;
         }else if(arr[i][j]>target){
            j--;
         }else{
            i++;
         }
      }
      return false;
  }

  public static void main(String[] args) {
    

   //  int[][] arr={{1,3,5,7},{10,11,16,20},{23,30,34,60}};
   //  int target=30;

   //   System.out.println(serachIn2Darr(arr, target));  
   
        int[][] arr={{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
      int target = 5;
       System.out.println(searchMatrix(arr, target));

       
      } 
}
