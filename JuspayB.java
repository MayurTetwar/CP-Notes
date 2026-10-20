import java.io.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;

class JuspayB {
    HashMap<String, Node> map;

    class Node {
        String name;
        Node par;
        int lockby;
        
        // 1. Thread-safe set for O(1) concurrent modifications
        Set<Node> lockedDes; 
        
        // 2. Read-Write lock for maximum throughput
        ReentrantReadWriteLock rwLock;

        public Node(String name, Node par) {
            this.name = name;
            this.par = par;
            this.lockby = -1;
            this.lockedDes = ConcurrentHashMap.newKeySet(); 
            this.rwLock = new ReentrantReadWriteLock();
        }
    }

    public JuspayB(String[] name, int m) {
        map = new HashMap<>();
        int n = name.length;
        for (int i = 0; i < n; i++) {
            Node par = (i == 0) ? null : map.get(name[(i - 1) / m]);
            Node node = new Node(name[i], par);
            map.put(name[i], node);
        }
    }

    // --- CONCURRENCY HELPERS ---

    // Get path from Root to Target node
    private List<Node> getPathFromRoot(Node node) {
        List<Node> path = new ArrayList<>();
        Node curr = node;
        while (curr != null) {
            path.add(curr);
            curr = curr.par;
        }
        Collections.reverse(path);
        return path;
    }

    // Acquire Shared Read Locks on Ancestors (Top-Down)
    private void acquireAncestorReadLocks(List<Node> ancestors) {
        for (Node n : ancestors) {
            n.rwLock.readLock().lock();
        }
    }

    // Release Shared Read Locks on Ancestors (Bottom-Up)
    private void releaseAncestorReadLocks(List<Node> ancestors) {
        for (int i = ancestors.size() - 1; i >= 0; i--) {
            ancestors.get(i).rwLock.readLock().unlock();
        }
    }

    // --- SYNCHRONIZED OPERATIONS ---

    public boolean lock(String name, int user) {
        Node node = map.get(name);
        if (node == null) return false;

        List<Node> ancestors = getPathFromRoot(node.par);

        // 1. Lock ancestors with SHARED Read Locks (Multiple threads can pass simultaneously)
        acquireAncestorReadLocks(ancestors);
        // 2. Lock target with EXCLUSIVE Write Lock
        node.rwLock.writeLock().lock();

        try {
            // Validation Phase
            if (node.lockby != -1) return false;
            if (!node.lockedDes.isEmpty()) return false;
            
            for (Node anc : ancestors) {
                if (anc.lockby != -1) return false;
            }
            
            // Execution Phase
            node.lockby = user;
            for (Node anc : ancestors) {
                anc.lockedDes.add(node); // Thread-safe due to ConcurrentHashMap KeySet
            }
            return true;
            
        } finally {
            // ALWAYS release locks to prevent system hang
            node.rwLock.writeLock().unlock();
            releaseAncestorReadLocks(ancestors);
        }
    }

    public boolean unlock(String name, int user) {
        Node node = map.get(name);
        if (node == null) return false;

        List<Node> ancestors = getPathFromRoot(node.par);

        acquireAncestorReadLocks(ancestors);
        node.rwLock.writeLock().lock();

        try {
            // Validation Phase
            if (node.lockby == -1 || node.lockby != user) return false;
            
            // Execution Phase
            node.lockby = -1;
            for (Node anc : ancestors) {
                anc.lockedDes.remove(node);
            }
            return true;
            
        } finally {
            node.rwLock.writeLock().unlock();
            releaseAncestorReadLocks(ancestors);
        }
    }

    public boolean upgrade(String name, int user) {
        Node node = map.get(name);
        if (node == null) return false;

        List<Node> ancestors = getPathFromRoot(node.par);

        acquireAncestorReadLocks(ancestors);
        node.rwLock.writeLock().lock();

        try {
            // 1. Validation Phase
            if (node.lockby != -1) return false;
            if (node.lockedDes.isEmpty()) return false;
            
            for (Node anc : ancestors) {
                if (anc.lockby != -1) return false;
            }
            
            // 2. Execution Phase
            // Note: Because we hold the WriteLock on this node, NO other thread can 
            // acquire a ReadLock on it. Therefore, no other thread can possibly be 
            // accessing its descendants. We can safely modify descendants without deadlocks!
            List<Node> toUnlock = new ArrayList<>();
            for (Node desc : node.lockedDes) {
                if (desc.lockby != user) return false;
                toUnlock.add(desc);
            }
            
            for (Node desc : toUnlock) {
                desc.lockby = -1; // Unlock descendant
                Node curr = desc.par;
                // Remove descendant from all intermediate ancestors up to the root
                while (curr != null) {
                    curr.lockedDes.remove(desc);
                    curr = curr.par;
                }
            }
            
            // Lock the target node
            node.lockby = user;
            for (Node anc : ancestors) {
                anc.lockedDes.add(node);
            }
            
            return true;
            
        } finally {
            node.rwLock.writeLock().unlock();
            releaseAncestorReadLocks(ancestors);
        }
    }

    // --- MAIN (FAST I/O) ---
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());
        
        String[] name = new String[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            name[i] = st.nextToken();
        }
        
        JuspayB obj = new JuspayB(name, m);
        
        // Simulating the thread queue
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            int op = Integer.parseInt(st.nextToken());
            String nodeName = st.nextToken();
            int uid = Integer.parseInt(st.nextToken());
            
            if (op == 1) {
                System.out.println(obj.lock(nodeName, uid));
            } else if (op == 2) {
                System.out.println(obj.unlock(nodeName, uid));
            } else {
                System.out.println(obj.upgrade(nodeName, uid));
            }
        }
    }
}