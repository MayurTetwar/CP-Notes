package Tree;

// file: EulerTour.java

import java.util.*;

public class EulerTour {

    static List<Integer>[] tree;
    static int[] tin, tout, flat;
    static int timer = 0;

    static void dfs(int node, int parent) {

        tin[node] = timer;
        flat[timer] = node;
        timer++;

        for (int child : tree[node]) {

            if (child == parent) continue;

            dfs(child, node);
        }

        tout[node] = timer - 1;
    }

    public static void main(String[] args) {

        int N = 5;

        tree = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++)
            tree[i] = new ArrayList<>();

        tree[1].add(2);
        tree[2].add(1);

        tree[1].add(3);
        tree[3].add(1);

        tree[2].add(4);
        tree[4].add(2);

        tree[2].add(5);
        tree[5].add(2);

        tin = new int[N + 1];
        tout = new int[N + 1];
        flat = new int[N];

        dfs(1, 0);

        System.out.println("Flattened tree:");
        System.out.println(Arrays.toString(flat));

        System.out.println("tin:");
        System.out.println(Arrays.toString(tin));

        System.out.println("tout:");
        System.out.println(Arrays.toString(tout));
    }
}
