package ArrayCPOneD;
import java.util.*;

/* Target Sum */
class ArrayP1{
  public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
   
    System.out.println("Enter size of Array: ");
    int n= sc.nextInt();
    
    int[] arr=new int[n];
    System.out.println("Enter "+arr.length+" number of array: ");
      for(int i=0;i<arr.length;i++){
        arr[i]=sc.nextInt();
      }

    System.out.println("Enter target number: ");
    int s= sc.nextInt();
     
    ArrayP1 obj=new ArrayP1();
    obj.getTwoNumbers(arr,s);
    getThreeNumbers(arr,s);

  }

  public void getTwoNumbers(int arr[],int t){
  
     int count=0;
     System.out.println("Sum Sets Are : ");
     for(int i=0; i<arr.length;i++){
        for(int j=i+1;j<arr.length;j++){
            if(arr[i]+arr[j]==t){
             System.out.println("["+arr[i]+","+arr[j]+"]");
              count++;
            }
        }
      }
      System.out.println("Total Sets are: "+count);
   } 
   static void getThreeNumbers(int arr[],int t){
  
    int count=0;
    System.out.println("Sum Sets Are : ");
    for(int i=0; i<arr.length;i++){
       for(int j=i+1;j<arr.length;j++){
           for(int k=j+1;k<arr.length;k++){
              if(arr[i]+arr[j]+arr[k]==t){
               System.out.println("["+arr[i]+","+arr[j]+","+arr[k]+"]");
                count++;
              }   
            }
       }
     }
     System.out.println("Total Sets are: "+count);
  } 
}