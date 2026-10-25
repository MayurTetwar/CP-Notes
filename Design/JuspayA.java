package Design;
import java.util.*;

// Tree-Space Algorithum (Hackathon PartA)
class JuspayA{

    HashMap<String,Node> map;
    class Node{
        String name;
        Node par;
        int lockby;
        Set<Node> lockedDes;
        public Node(String name,Node par){
            this.name=name;
            this.par=par;
            lockby=-1;
            lockedDes=new HashSet<>();
        }
    }

    public JuspayA(String[] name,int m){
        map=new HashMap<>();
        int n=name.length;
        for(int i=0;i<n;i++){
            Node par=(i==0)?null:map.get(name[(i-1)/m]);
            Node node=new Node(name[i],par);
            map.put(name[i],node);
        }
    }

    public boolean lock(String name,int user){
        Node node=map.get(name);
        // condition 1
        if(node.lockby!=-1)return false;
        // condition 2
        Node curr=node.par;
        while(curr!=null){
            if(curr.lockby!=-1)return false;
            curr=curr.par;
        }
        // condition 3
        if(!node.lockedDes.isEmpty())return false;
        node.lockby=user;
        lockUp(node.par,node);
        return true;
    }

    // add decendends to upper nodes as current node is lock
    public void lockUp(Node curr,Node node){
        while(curr!=null){
            curr.lockedDes.add(node);
            curr=curr.par;
        }
    }

    public boolean unlock(String name,int user){
        Node node=map.get(name);
        // condition 1 and 2
        if(node.lockby==-1 || node.lockby!=user)return false;
        node.lockby=-1;
        unlockUp(node.par,node);
        return true;
    }

    // remove decendends to upper nodes as current node is lock
    public void unlockUp(Node curr,Node node){
        while(curr!=null){
            curr.lockedDes.remove(node);
            curr=curr.par;
        }
    }
    
    public boolean upgrade(String name,int user){
        Node node=map.get(name);
        // condition 1
        if(node.lockby!=-1)return false;
        // condition 2
        Node curr=node.par;
        while(curr!=null){
            if(curr.lockby!=-1)return false;
            curr=curr.par;
        }
        // condition 3
        if(node.lockedDes.isEmpty())return false;
        // condition 4
        List<Node> toUnlock=new ArrayList<>();
        for(Node child:node.lockedDes){
            if(child.lockby==user)toUnlock.add(child);
            else return false;
        }    
        for(Node child:toUnlock){
            unlock(child.name, user);
        }
        lock(name,user);
        return true;
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        int q=sc.nextInt();
        String[] name=new String[n];
        for(int i=0;i<n;i++){
            name[i]=sc.next();
        }
        
        JuspayA obj=new JuspayA(name,m);
        sc.nextLine();
        while(q-->0){
            String[] input=sc.nextLine().split(" ");
            int op=Integer.parseInt(input[0]);
            int uid=Integer.parseInt(input[2]);
            if(op==1){
                System.out.println(obj.lock(input[1], uid));
            }else if(op==2){
                System.out.println(obj.unlock(input[1], uid));
            }else{
                System.out.println(obj.upgrade(input[1], uid));
            }
        }
    }
}
/*
The Problem: Tree of Space (Locking & Unlocking an $M$-ary Tree)

You are given a list of $N$ strings representing the nodes of a complete, balanced $M$-ary tree 
in level-order traversal. You need to support three operations on this tree: lock, unlock, and upgrade.
Each query contains an operation type, a node name, and a user ID (uid). The system must return true 
if the operation succeeds and false if it fails.

1. Lock (Node $X$, User $uid$)
Takes exclusive access to the subtree rooted at $X$.
Succeeds ONLY IF all these conditions are met:
    1. Node $X$ is currently unlocked.
    2. No ancestor of $X$ is locked by any user.
    3. No descendant of $X$ is locked by any user.

2. Unlock (Node $X$, User $uid$)
Reverts the lock operation on node $X$.
Succeeds ONLY IF all these conditions are met:
    1. Node $X$ is currently locked.
    2. Node $X$ was locked by the same $uid$ (users cannot unlock other users' locks).

3. Upgrade (Node $X$, User $uid$)
Upgrades the lock to the ancestor node $X$, absorbing the locks of its descendants.
Succeeds ONLY IF all these conditions are met:
    1. Node $X$ is currently unlocked.
    2. No ancestor of $X$ is locked by any user.
    3. At least one descendant of $X$ is locked.
    4. All currently locked descendants of $X$ must be locked by the same $uid$ making the request.
       If successful, this operation locks node $X$ for $uid$ and automatically unlocks all its locked 
       descendants.

Input Format
    1. $N$: Total number of nodes in the tree.
    2. $M$: Maximum number of children per node.
    3. $Q$: Number of queries.
    4. Nodes: $N$ lines of strings, representing the tree in level-order 
       (index 0 is the root, children of index $i$ are at $M \times i + 1$ to $M \times i + M$).
    5. Queries: $Q$ lines of space-separated strings in the format [OpCode] [NodeName] [UserId].
       OpCode 1 = Lock
       OpCode 2 = Unlock
       OpCode 3 = Upgrade

Example Walkthrough
Input 1:
    N = 7, M = 2, Q = 5
    Nodes = ["World", "Asia", "Africa", "China", "India", "SouthAfrica", "Egypt"]
    Queries = [
        "1 China 9", 
        "1 India 9", 
        "3 Asia 9", 
        "2 India 9", 
        "2 Asia 9"
        ]
Output: true true true false true

Input 2:
7
2
8
World
Asia
Africa
China
India
SouthAfrica
Egypt
1 China 9
1 India 9
3 Asia 9
2 India 9
1 China 5
2 Asia 9
1 World 5
1 Asia 7

Output: 
true
true
true
false
false
true
true
false
*/