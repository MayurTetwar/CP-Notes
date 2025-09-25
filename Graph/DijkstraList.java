package Graph;
import java.util.*;

class DijkstraList {
    static class Pair {
        int node;
        int cost;

        Pair(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        
        int n = 6; // Number of vertices
        List<List<Pair>> graph = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        // Add edges
        graph.get(0).add(new Pair(1, 4));
        graph.get(0).add(new Pair(2, 1));
        graph.get(2).add(new Pair(1, 2));
        graph.get(1).add(new Pair(3, 1));
        graph.get(2).add(new Pair(3, 5));
        graph.get(3).add(new Pair(4, 3));
        graph.get(4).add(new Pair(5, 1));

        int src = 2;
        int[] distances = dijkstra(src,graph, n);

        // Print shortest distances
        System.out.println("Shortest distances from vertex " + src + ":");
        for (int i = 0; i < n; i++) {
            System.out.println("Vertex " + i + ": " + distances[i]);
        }
    }

    public static int[] dijkstra(int src,List<List<Pair>> graph,int n){

        PriorityQueue<Pair> Q=new PriorityQueue<>(Comparator.comparingInt(pair->pair.cost));
        int dist[] = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Q.add(new Pair(src, 0));
        while(!Q.isEmpty()){
            Pair curr=Q.poll();
            int u = curr.node; // node number
            int cost=curr.cost; // edge codt to node number
            if(cost>dist[u])continue;

            for(Pair neighbor: graph.get(u)){
                int node=neighbor.node;
                int weight=neighbor.cost;
                if(dist[node]>dist[u]+weight){
                    dist[node]=dist[u]+weight;
                    Q.add(new Pair(node,dist[node]));
                }
            }
        }
        return dist;
    }
}
