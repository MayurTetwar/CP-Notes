package DSU;

import java.util.*;

public class ReverseQueryDSU {
    int[] par;
    public int find(int x){
        if(par[x]!=x){
            par[x]=find(par[x]);
        }
        return par[x];
    }
    public void solve(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        long mod=1000000007;
        long[] arr=new long[n];
        for (int i = 0; i < n; i++) {
            arr[i]=sc.nextLong();
        }
        int q=sc.nextInt();
        par=new int[n+1];
        for(int i=1;i<=n;i++)par[i]=i;

        int[][] qu=new int[q][4];
        for(int i=0;i<q;i++){
            int l=sc.nextInt();
            int r=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            qu[i][0]=l;
            qu[i][1]=r;
            qu[i][2]=x;
            qu[i][3]=y;
        }
        for(int i=q-1;i>=0;i--){
            int l=qu[i][0];
            int r=qu[i][1];
            int x=qu[i][2];
            int y=qu[i][3];
            
            int next=find(l);
            while(next<=r){
                arr[next]=(x+y*(next-l))%mod;
                par[next]=find(next+1);
                next=par[next];
            }
        }

        long sum=0;
        for(int i=0;i<n;i++){
            sum=(sum+arr[i])%mod;
        }
        System.out.println(sum);
        //print("------------------------");
    }
}
