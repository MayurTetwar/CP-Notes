package Trie;

/*
static class Trie {
        Trie[] next;
        boolean isEnd; // marks the end of a number
        public Trie() {
            next=new Trie[2]; // Binary 
            isEnd=false;
        }
    }
    public static void insert(Trie root,int bitLength,int num){
        Trie curr = root;
        for (int i = bitLength; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (curr.next[bit] == null) curr.next[bit] = new Trie();
            curr = curr.next[bit];
        }
        curr.isEnd = true;    
    }
 */

class TrieExapmle {

    static class Trie {
        Trie[] next; // Children nodes
        boolean isEnd; // Marks the end of a valid string/number
        int count; // count of the node from the root

        // Constructor
        public Trie() {
            this.next = new Trie[10]; // Assuming digits 0-9
            this.isEnd = false;
            this.count= 1000000;
        }
    }

    static Trie root;

    public static void main(String[] args) {

        System.out.println(findKthNumber(13, 3));
    }

    public static int findKthNumber(int n, int k) {
        root = build(n);
        StringBuilder str= new StringBuilder();
        int i=0;
        while(k>0){
            for (i = 0; i < 10; i++) {
                if (root.next[i] != null) {
                    if (root.next[i].count >= k)
                        break;
                    k = k - root.next[i].count;
                }
            }
            k--;
            if(i==10)break;
            root=root.next[i];
            str.append(i);
        }
        return Integer.parseInt(str.toString());
    }

    public static Trie build(int n) {
        Trie root = new Trie();
        for (int i = 1; i <= n; i++) {
            Trie curr = root;
            String numStr = Integer.toString(i);
            for (char num : numStr.toCharArray()) {
                if (curr.next[num - '0'] == null)
                    curr.next[num - '0'] = new Trie();
                curr = curr.next[num - '0'];
                curr.count++;
            }
            curr.isEnd = true;
        }
        return root;
    }

    public static void printTrie(Trie root, String str) {
        if (root.isEnd) {
            System.out.println(str + " " + root.count);
        }
        for (int i = 0; i < 10; i++) {
            if (root.next[i] != null) {
                printTrie(root.next[i], str + i);
            }
        }
    }
}