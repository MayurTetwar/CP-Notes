package Graph;
import java.util.*;

public class DijkstraArray {
    static class Cell {
        int x, y, cost;
        Cell(int x, int y, int cost) {
            this.x = x;     // Row index
            this.y = y;     // Column index
            this.cost = cost; // Accumulated cost to reach this cell
        }
    }

    // Function to calculate the minimum cost path
    public static int minCost(int[][] arr) {
        int n = arr.length; // Number of rows
        int m = arr[0].length; // Number of columns

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        PriorityQueue<Cell> pq=new PriorityQueue<>(Comparator.comparingInt(cell->cell.cost));
        
        int[][] dist = new int[n][m];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE); // Initialize all distances to "infinity"
        dist[0][0] = arr[0][0]; // Cost to reach the starting cell (0, 0) is its own cost

        pq.add(new Cell(0, 0, arr[0][0])); // Add the starting cell to the priority queue

        while (!pq.isEmpty()) {
            Cell curr = pq.poll(); // Remove the cell with the smallest cost
            int x = curr.x;
            int y = curr.y;

            // if (x == n - 1 && y == m - 1) {
            //     return curr.cost;
            // }

            for (int[] dir : directions) {
                int newX = x + dir[0]; // New row
                int newY = y + dir[1]; // New column

                if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
                    int newCost = curr.cost + arr[newX][newY]; // Accumulated cost to reach the new cell
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost; // Update the shortest distance
                        pq.add(new Cell(newX, newY, newCost)); // Add the new cell to the queue
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
        return -1;
    }

    /*
     For printing all distace from 0,0 =>

        // Remove this block:
        if (x == n - 1 && y == m - 1) {
            return curr.cost;
        }

        // Add this after the while loop:
        System.out.println("Minimum distances from (0, 0):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }

     */
    public static void main(String[] args) {
        int[][] arr = {
            {1,9,9,1},
            {1,4,4,1},
            {1,1,1,1}
                    };
        minCost(arr);
    }
}
