package ArrayCPOneD;

import java.util.*;

/* Cheak if number present in Array or Not */
class ArrayQuery{
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);   
        
         System.out.println("Enter size of Array: ");
         int n= sc.nextInt();
          
         int[] arr=new int[n];
         System.out.println("Enter "+arr.length+" number of array: ");
            for(int i=0;i<arr.length;i++){
              arr[i]=sc.nextInt();
            } 
           
          int freq[] = makeFrequancyArray(arr);  
          System.out.println("Enter number  of Queries: ");
          int q=sc.nextInt();
    
          while (q>0) {
            System.out.println("Enter number to be search: ");
            int x=sc.nextInt();
            if(freq[x]>0){
              System.out.println("YES");
            }else{
              System.out.println("NO");
            }
            q--;
          }

    }
    
    static int[] makeFrequancyArray(int arr[]){
           
      int freq[] = new int[10005];  // Declaring Frequancy array 
      int n=arr.length;
      for(int i=0;i<n;i++){
          freq[arr[i]]++;           // Increase at index in arr[]
      }
      return freq;
    }
}