package Graph;
import java.util.*;

public class DijkstraAddjecency {
    public static void main(String[] args) {
        
        
    }
    public static void dijkstra(int n, int[][] arr,int start){
        int dist[]=new int[n];
        boolean[] visited=new boolean[n];
        Arrays.fill(visited,false);
        for(int i=0;i<n;i++){
            dist[i]=arr[start][i];
        }
        visited[start]=true;
        dist[start]=0;
        for(int count=1;count<n-1;count++){
            int mindistance=Integer.MAX_VALUE;
            int nextNode=0;
            for (int i = 0; i < n; i++) {
                if(mindistance>dist[i]){
                    mindistance=dist[i];
                    nextNode=i;
                }
            }
            visited[nextNode]=true;
            for (int i = 0; i < n; i++) {
                if(!visited[i]){
                    if(dist[i]>arr[nextNode][i]+mindistance){
                        dist[i]=arr[nextNode][i]+mindistance;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if (i != start) {
                System.out.printf("\nDistance from %d to %d: %d", start, i, dist[i]);
            }
        }
    }
}

/*
import java.util.Arrays;

public class DijkstraAlgorithm {
    private static final int INFINITY = Integer.MAX_VALUE;

    public static void dijkstra(int n, int[][] cost, int start) {
        int[] distance = new int[n];
        int[] pred = new int[n];
        boolean[] visited = new boolean[n];
        int count, mindistance, nextnode;

        for (int i = 0; i < n; i++) {
            distance[i] = cost[start][i];
            pred[i] = start;
            visited[i] = false;
        }
        distance[start] = 0;
        visited[start] = true;
        count = 1;

        while (count < n - 1) {
            mindistance = INFINITY;
            for (int i = 0; i < n; i++) {
                if (distance[i] < mindistance && !visited[i]) {
                    mindistance = distance[i];
                    nextnode = i;
                }
            }
            visited[nextnode] = true;
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    if (mindistance + cost[nextnode][i] < distance[i]) {
                        distance[i] = mindistance + cost[nextnode][i];
                        pred[i] = nextnode;
                    }
                }
            }
            count++;
        }

        // Printing the distance
        for (int i = 0; i < n; i++) {
            if (i != start) {
                System.out.printf("\nDistance from %d to %d: %d", start, i, distance[i]);
            }
        }
    }
}


 */