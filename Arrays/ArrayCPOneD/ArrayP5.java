package ArrayCPOneD;
import java.util.*;

/*
  Given an array of N integers where each value represents the number of chocolates
  in a packet. Each packet can have a variable number of chocolates. 
  There are m students, the task is to distribute chocolate packets such that: 
  1.Each student gets one packet.
  2.The difference between the number of chocolates in the packet with maximum
    chocolates and the packet with minimum chocolates given to the students is minimum.
 */
public class ArrayP5 {
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        
        System.out.println("Enter array size:");
        int n=sc.nextInt();

        int[] arr=new int[n];
        System.out.println("Enter "+n+" numbers in array:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        System.out.println("Enter the numbers of students: ");
        int m=sc.nextInt();

        int mindiff=arr[n-1];
        if(m!=0)
        for(int i=0;i<n-m+1;i++){
            int getdiff=arr[m+i-1]-arr[i];
            if(mindiff>getdiff){
               mindiff=getdiff;
            }
        }
        System.out.println(mindiff);
    }
}
