package DynamicPrograming;

import java.util.Scanner;

/* Count numbers ≤ num whose sum of digits ≤ max */
public class DigitDP_Sum {

    static String num;
    static int max;
    static Long[][][] dp;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter limit:- ");
        num=String.valueOf(sc.nextLong());
        System.out.println("Enter max sum :- ");
        max=sc.nextInt();
        dp=new Long[num.length()][2][max+1];
        System.out.println(count(0,1,0));
    }
    public static long count(int pos, int tight,int sum)  {
        if(sum>max)return 0;
        if(pos==num.length())return 1;
        if(dp[pos][tight][sum]!=null)return dp[pos][tight][sum];
        int limit = (tight==1)?num.charAt(pos)-'0':9;
        long ans=0;
        for (int i = 0; i <= limit; i++) {
            int newtight = (tight==1 && i==limit)?1:0;
            ans+=count(pos+1,newtight,sum+i);
        }
        return dp[pos][tight][sum]=ans;
    }
}
