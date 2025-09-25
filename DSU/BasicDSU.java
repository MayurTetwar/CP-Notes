package DSU;

// Disjoin Set Union

class BasicDSU {
    private int[] parent;
    private int n;

    // Constructor: Initially each element is its own parent
    public BasicDSU(int n) {
        this.n = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element is its own set initially
        }
    }

    // Find operation: Returns the root/representative of the set containing x
    public int find(int x) {
        if (parent[x] != x) {
            // If x is not the root, recursively find the root
            return find(parent[x]);
        }
        return x; // x is the root of its set
    }

    // Union operation: Merge sets containing x and y
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // If they're already in the same set, do nothing
        if (rootX != rootY) {
            parent[rootX] = rootY; // Make rootY the parent of rootX
        }
    }

    // Check if two elements are in the same set
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    // Example usage
    public static void main(String[] args) {
        BasicDSU dsu = new BasicDSU(5); // Elements 0, 1, 2, 3, 4

        System.out.println("Initial state:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Element " + i + " is in set with root " + dsu.find(i));
        }

        // Union some elements
        dsu.union(0, 1);
        dsu.union(2, 3);
        dsu.union(1, 2);

        System.out.println("\nAfter unions:");
        for (int i = 0; i < 5; i++) {
            System.out.println("Element " + i + " is in set with root " + dsu.find(i));
        }

        System.out.println("\nConnectivity checks:");
        System.out.println("0 and 3 connected: " + dsu.isConnected(0, 3)); // true
        System.out.println("0 and 4 connected: " + dsu.isConnected(0, 4)); // false
    }
}