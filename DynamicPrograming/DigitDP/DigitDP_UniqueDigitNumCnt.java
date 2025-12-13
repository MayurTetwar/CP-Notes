package DynamicPrograming.DigitDP;

import java.util.Scanner;

class DigitDP_UniqueDigitNumCnt{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(countNumbersWithUniqueDigits(sc.nextInt()));
    }
    static String num;
    static Integer[][][][] memo;
    public static int countNumbersWithUniqueDigits(int n) {
        int limit =(int)Math.pow(10,n)-1;
        // System.out.println(limit);
        num=String.valueOf(limit);
        memo=new Integer[num.length()][2][(1<<10)][2];
        return helper(0,1,0,0);
    }
    public static int helper(int pos,int tight,int mask,int started){
        if(pos==num.length())return 1;
        if(memo[pos][tight][mask][started]!=null)return memo[pos][tight][mask][started];
        int limit = (tight==1)?num.charAt(pos)-'0':9;
        int ans=0;
        for(int i=0;i<=limit;i++){
            int newtight = (tight==1 && i==limit)?1:0;
            int newStarted=(started==0 && i==0)?0:1;
            if(newStarted==1 && (mask&(1<<i))!=0)continue;
            int newmask = (newStarted==1)?(mask|(1<<i)):mask;
            ans+=helper(pos+1,newtight,newmask,newStarted);
        }
        return memo[pos][tight][mask][started]=ans;
    }
}