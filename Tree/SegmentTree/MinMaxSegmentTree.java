package Tree.SegmentTree;

import java.util.Scanner;

/*
Converting to MAX is as simple as:
1. Math.min → Math.max
2. Integer.MAX_VALUE → Integer.MIN_VALUE
*/
public class MinMaxSegmentTree {
    static int n;
    static int[] tree;

    static void build(int[] arr,int node,int st,int end){
        if(st==end){
            tree[node]=arr[st];
        }else{
            int mid=(st+end)/2;
            build(arr, node*2, st, mid);
            build(arr, node*2+1, mid+1, end);
            tree[node]=Math.min(tree[node*2],tree[node*2+1]);
        }
    }
    static int query(int l,int r){
        return query(1,0,n-1,l,r);
    }
    static int query(int node,int st,int end,int l,int r){
        if(end<l || r<st)return Integer.MAX_VALUE;
        if(l<=st && end<=r)return tree[node];
        int mid=(st+end)/2;
        int left=query(node*2, st, mid, l, r);
        int right=query(node*2+1, mid+1,end, l, r);
        return Math.min(left,right);
    }
    static void update(int node,int st,int end,int ind,int val){
        if(st==end){
            tree[node]=val;
        }else{
            int mid=(st+end)/2;
            if(ind<=mid){
                update(node*2, st, mid, ind, val);
            }else{
                update(node*2+1, mid+1, end, ind, val);
            }
            tree[node]=Math.min(tree[node*2],tree[node*2+1]);
        }
    }
    public static void main(String[] args) {
        
        int[] arr={1,8,3,6,5};
        n=arr.length;
        tree=new int[n*4];

        build(arr, 1, 0, n-1);
        update(1, 0, n-1, 0, 5);

        System.out.println("Enter No. Of Query :- ");
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        for(int i=0;i<q;i++){
            System.out.println("Enter range :- ");
            System.out.println("Min :- "+query(sc.nextInt(),sc.nextInt()));
        }
    }
}
