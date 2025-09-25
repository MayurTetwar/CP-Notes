package ArrayCPTwoD;
import java.util.*;

public class RandomPro {
    public static void main(String[] args) {
        
        Scanner sc= new Scanner(System.in);

        System.out.println("Enter rows and cols :");
        int n=sc.nextInt();
        int m=sc.nextInt();

        int[][] arr=new int[n][m]; 
        System.out.println("Enter "+(n*m)+" numbers in array:");
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        int temp=0,index=-1;
        for(int i=0;i<arr.length;i++){
            int count=0;
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==1)
                  count++;
            }

            if(count>temp){
                temp=count;
                index=i;
            }
        }
        if(index!=-1)
        System.out.println("Row ="+index+" has maximum number of 1's. that is "+temp);
        else
        System.out.println("NO such row presente which have 1.");

    }
}
