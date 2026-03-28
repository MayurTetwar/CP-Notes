package Tree.STonTree;
import java.util.*;

public class NodeU_SubtreeQuery {

    static int n;
    static List<List<Integer>> tree;
    static int[] values;

    static int[] flat;
    static int[] in, out;
    static int timer = 0;

    static long[] seg;

    static void dfs(int node, int parent) {
        in[node] = timer;
        flat[timer] = values[node];
        timer++;

        for (int child : tree.get(node)) {
            if (child == parent) continue;
            dfs(child, node);
        }

        out[node] = timer - 1;
    }

    static void build(int node, int st, int end) {
        if (st == end) {
            seg[node] = flat[st];
            return;
        }

        int mid = (st + end) / 2;
        build(2 * node + 1, st, mid);
        build(2 * node + 2, mid + 1, end);

        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    static long query(int node, int st, int end, int l, int r) {
        if (r < st || end < l) return 0;

        if (l <= st && end <= r) return seg[node];

        int mid = (st + end) / 2;

        return query(2 * node + 1, st, mid, l, r) +
               query(2 * node + 2, mid + 1, end, l, r);
    }

    static void update(int node, int st, int end, int pos, int val) {
        if (st == end) {
            seg[node] = val;
            return;
        }

        int mid = (st + end) / 2;

        if (pos <= mid) {
            update(2 * node + 1, st, mid, pos, val);
        } else {
            update(2 * node + 2, mid + 1, end, pos, val);
        }

        seg[node] = seg[2 * node + 1] + seg[2 * node + 2];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        int q=sc.nextInt();
        int[] arr=new int[n];
        tree=new ArrayList<>();
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        out=new int[n];
        in=new int[n];
        seg=new long[n*4];
        flat=new int[n];
        for(int i=0;i<n;i++){
            tree.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++){
            int u=sc.nextInt()-1;
            int v=sc.nextInt()-1;
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        dfs(0,-1);
        build(1, 0, n-1);
        while(q-->0){
            int t=sc.nextInt();
            if(t==1){
                int idx=sc.nextInt()-1;
                int val=sc.nextInt();
                // update(int node,int st,int end,int idx,int val)
                update(1,0, n-1, in[idx], val);
            }else{
                int s=sc.nextInt()-1;
                System.out.println(query(1, 0, n-1, in[s], out[s]));
            }
        }
    }
}