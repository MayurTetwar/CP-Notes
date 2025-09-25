package Trie; 

class MaximumXor {

    public static class TrieNodeB{
        TrieNodeB[] next=new TrieNodeB[2];
        int num;
    }
    public static TrieNodeB build(int[] arr){
        TrieNodeB root=new TrieNodeB();
        for(int num:arr){
            TrieNodeB curr=root;
            for(int i=0;i<=31;i++){
                int bit=(num>>i)&1;
                if(root.next[bit]==null)root.next[bit]=new TrieNodeB();
                curr=root.next[bit];
            }
            root.num=num;
        }
        return root;
    }
    public static int getXOR(int num,TrieNodeB root,int i) {
        int bit = (num >> i) & 1;
        if(root.next[1-bit]!=null){
            return getXOR(num, root.next[1-bit], i+1);
        }else if(root.next[bit]!=null){
            return getXOR(num, root.next[bit], i+1);
        }else{
            return root.num;
        }
    }
    public static int findMaximumXOR(int[] arr) {
        int ans=0;
        TrieNodeB root=build(arr);
        for(int num:arr){
            int another=getXOR(num,root,0);
            if(another!=-1)
                ans=Math.max(ans,num^another);
        }
        return ans;
    }
    public static void main(String[] args) {
        
    }
}
