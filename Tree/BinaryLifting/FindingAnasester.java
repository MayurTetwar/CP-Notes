package Tree.BinaryLifting;

import java.util.*;

// finding k above node in tree
public class FindingAnasester {
    int[][] up;
    public void dfs(List<List<Integer>> list,int[] depth,int curr,int par){
        up[curr][0]=par;
        for(int ne:list.get(curr)){
            if(ne==par)continue;
            depth[ne]=depth[curr]+1;
            dfs(list, depth, ne, curr);
        }
    }
    public void solve(){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();

        int log=0;
        while((1<<log)<=n)log++;
        up=new int[n+1][log+1];
        for(int i=0;i<=n;i++){
            Arrays.fill(up[i],-1);
        }
        int[] depth=new int[n+1];
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int v=sc.nextInt();
            list.get(i+2).add(v);
            list.get(v).add(i+2);
        }
        depth[1]=0;
        dfs(list, depth, 1,-1 );

        for(int j=1;j<=log;j++){
            for (int i= 1; i<= n; i++) {
                if(up[i][j-1]!=-1){
                    up[i][j]=up[up[i][j-1]][j-1];
                }
            }
        }

        while(q-->0){
            int x=sc.nextInt();
            int level=sc.nextInt();
            // print(depth[x]);
            for(int i=0;i<log;i++){
                if((level&(1<<i))!=0){
                    x=up[x][i];
                    if(x==-1)break;
                }
            }
            System.out.println(x);
        }
    }
}
