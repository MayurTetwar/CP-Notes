package Recursion;


public class LadderStep {

    static int getCount(int n,int count){

        if(n==0){
            return 0;
        }else if(n==1){
            return 1;  
        }else if(n==2){
            return 2;
        }else if(n==3){
            return 4;
        }

        count+=getCount(n-1, count);
        count+=getCount(n-2, count);
        count+=getCount(n-3, count);
        return count;
    }
    public static void main(String[] args) {
        
       int ans= getCount(4, 0);
       System.out.println(ans);
    }
}
