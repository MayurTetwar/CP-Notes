package DSU;

// We can skip rank array as remove (A) and (C)
// Most imp is path Compression at (B)

class OptimizedDSU {
    private int[] parent;
    private int[] rank; // Height/depth of the tree rooted at each node
    private int components; // Number of connected components

    public OptimizedDSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        this.components = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i; // Each element is its own parent
            rank[i] = 0; // Initial rank is 0 --------(A)
        }
    }

    // Find with Path Compression
    public int find(int x) {
        if (parent[x] != x) {
            // Path compression: Make all nodes on the path point directly to root
            parent[x] = find(parent[x]); // ------(B)
        }
        return parent[x];
    }

    // Union by Rank
    public boolean union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        // Already in same set
        if (rootX == rootY) {
            return false;
        }
        // ------(C)
        // Union by rank: attach smaller tree under root of larger tree
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            // Same rank: choose one as root and increment its rank
            parent[rootY] = rootX;
            rank[rootX]++;
        }

        components--; // Reduce number of components
        return true;
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }

    public int getComponents() {
        return components;
    }

    // Not IMP
    // Get size of the component containing x
    public int getSize(int x) {
        int root = find(x);
        int size = 0;
        for (int i = 0; i < parent.length; i++) {
            if (find(i) == root) {
                size++;
            }
        }
        return size;
    }

    // Example demonstrating optimizations
    public static void main(String[] args) {
        OptimizedDSU dsu = new OptimizedDSU(6);

        System.out.println("Initial components: " + dsu.getComponents());

        // Create connections
        dsu.union(0, 1);
        dsu.union(1, 2);
        dsu.union(3, 4);

        System.out.println("After unions: " + dsu.getComponents() + " components");

        // Test connectivity
        System.out.println("0 and 2 connected: " + dsu.isConnected(0, 2));
        System.out.println("2 and 4 connected: " + dsu.isConnected(2, 4));

        // Show component sizes
        System.out.println("Size of component containing 0: " + dsu.getSize(0));
        System.out.println("Size of component containing 5: " + dsu.getSize(5));
    }
}
