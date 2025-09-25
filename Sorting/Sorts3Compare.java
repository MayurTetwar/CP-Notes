package Sorting;


 class Sorts3Compare{
   // PRINTING METHOD
   static void print(int arr[]){
     for(int i=0;i<arr.length;i++){
       System.out.print(arr[i]+" ");
     }
     System.out.println();
   }
   
   
   /* Main Method*/
   public static void main(String args[]){ 
    int arr[]={2,5,3,7,4,8};
    System.out.print("original Array is : ");
    print(arr);
    int[] arr1=arr.clone();
    int[] arr2=arr.clone();
    MybubbleSort(arr2);
    MyselectionSort(arr);
    newInsertion(arr1);
    print(arr2);
   }

   /* Bubble Sort */
   static void MybubbleSort(int[] arr){

    int n=arr.length;
    for(int i=0;i<n-1;i++){
      boolean flag=false;
      for(int j=0;j<n-1-i;j++){
        if(arr[j]>arr[j+1]){
          int temp=arr[j];
          arr[j]=arr[j+1];
          arr[j+1]=temp;
          flag=true;
        }
      }
      if(!flag){
        return;
      }
    }
    System.out.print("Bubble Sort Result : ");
    print(arr);
   }

   /* Selection sort */
   static void MyselectionSort(int[] arr){

    int n=arr.length;
    for(int i=0;i<n;i++){
      int min=arr[i];
      int index=i;
      for(int j=i;j<n;j++){
        if(min>arr[j]){
           min=arr[j];
           index=j;
        }
      }
      int temp=arr[index];
      arr[index]=arr[i];
      arr[i]=temp;
    }
    System.out.print("Selection Sort Result : ");
    print(arr);
   }

   /* Insertion Sort */
   static void MyinsertionSort(int[] arr){
    
    int n=arr.length;

    for(int i=1;i<n;i++){
      int key=arr[i];
      int j=i;
      while(j>0 && arr[j-1]>key){
        arr[j]=arr[j-1];
        j--;
      }
      arr[j]=key;
    }
    System.out.print("Insertion Sort Result : ");
    print(arr);
   }
   
   /* New Insertion Sort */
   static void newInsertion(int arr[]){
     
    int n=arr.length;
    for(int i=1;i<n;i++){
      for(int j=i;j>0;j--){
         if(arr[j]<arr[j-1]){
           int temp=arr[j];
           arr[j]=arr[j-1];
           arr[j-1]=temp;
         }else{
            break;
         }
      }
    }
    print(arr);
   }
}