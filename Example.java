import java.util.*;

public class Example {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        HashMap<Integer,Integer> map=new HashMap<>();
        TreeMap<Integer,Integer> tm=new TreeMap<>();
        String str="Mayur";
        Stack<Integer> stk=new Stack<>();
        Queue<Integer> q=new LinkedList<>();
        Deque<Integer> dq=new LinkedList<>();
        HashSet<Integer> set=new HashSet<>();
        TreeSet<Integer> ts=new TreeSet<>();
        List<Integer> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        PriorityQueue<Integer> pq=new PriorityQueue<>(Comparator.reverseOrder());
        int[] arr=new int[10];
        char ch='a';
        BitSet bs = new BitSet(10); 
        Integer num=12345;
       
        
        
    }
}
