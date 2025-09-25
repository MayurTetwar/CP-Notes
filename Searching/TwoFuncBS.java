package Searching;

class TwoFuncBS{

    /* Problem1 */ 
    static boolean isDivisionPossible(int[] arr,int m,int maxChocAllowed){

        int noOfStu=1;
        int choc=0;     // Number of choclate of curr student
        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxChocAllowed) return false;
            if(arr[i]+choc<=maxChocAllowed){  // mid must be greter than yotal no. of choclates
                choc+=arr[i];
            }else{
                noOfStu++;
                choc=arr[i];
            }
        }
        // if(noOfStu>m) return false;
        // return true;
        return noOfStu<=m;
    }
    static int distributesChoclates(int[] arr,int m){

        if(arr.length<m) return -1;
        int ans=0,start=1,end=(int)1e9;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if(isDivisionPossible(arr,m,mid)){ 
                ans=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return ans;
    }
    // Finding Minimal Maxima /* TC=O(n*log(n)) */
    

    /* Problem2 */
    static boolean isPossible(int arr[],int m,int dist){
        int kidsPlaced=1;
        int lastKid=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]-lastKid>=dist){
                kidsPlaced++;
                lastKid=arr[i];
            }
        }
        return kidsPlaced>=m;
    }
    static int raceTrack(int arr[],int m){
        
        if(arr.length<m) return -1;
        int ans=0,start=1,end=(int)1e9;

        while (start<=end) {
            int mid=start+(end-start)/2;
            if(isPossible(arr,m,mid)){  // Can k kids be placed such that no 2 kids have distance lesser than mid
                ans=mid;
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return ans;
    }
    // Finding Maximul Minimum /* TC=O(n*log(n)) */
    
    
    /* Kth Smallest Element in a Sorted Matrix or may be first element is not grether than last elemnt of previous row.*/
    static int kthSmallElement(int[][] arr,int k){

        int n=arr.length;
        int m=arr[0].length;
        int start=arr[0][0];
        int end=arr[n-1][m-1];
        int ans=0;
        while (start<=end) {
            int mid = (start+end)/2;
            if (countLessEqual(arr, mid) >= k) {
                end=mid-1;
                ans=mid;
            }else{
                start=mid+1;
            }
        }
     return ans;
    }
    static int countLessEqual(int[][] arr,int mid){
        int n=arr.length;
        int m=arr[0].length;
        int count=0;
        int col=m-1;
        for(int i=0;i<n;i++){
            while (col>=0 && arr[i][col]>mid) {
                col--;
            }
            count+=(col+1);
        }
        return count;
    }
  
    public static void main(String[] args) {
        
        /* Problem 1 Input */
        // int arr[]={12,34,67,90};
        // int m=2;
        // System.out.println(distributesChoclates(arr, m));

        /* Problem 2 Input */
        //  int arr[]={1,2,4,8,9};
        //  int m=3;
        // System.out.println(raceTrack(arr, m));

         int[][]arr = {{1,5,9},{10,11,13},{12,13,15}};
         int k = 8;
   
         System.out.println(kthSmallElement(arr, k));
    }
}