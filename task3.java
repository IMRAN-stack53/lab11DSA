/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mujtaba Abr
 */

    
import java.util.*;

public class task3 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public task3(int vertices) {
        this.vertices = vertices;
        this.adjacencyMatrix = new int[vertices][vertices];
    }

    public void addEdge(int u, int v) {
        adjacencyMatrix[u - 1][v - 1] = 1;
        adjacencyMatrix[v - 1][u - 1] = 1; // for undirected graph
    }

    public void displayAdjacencyMatrix() {
        System.out.println("Adjacency Matrix:");
        System.out.print("  ");
        for (int i = 1; i <= vertices; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        for (int i = 0; i < vertices; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < vertices; j++) {
                System.out.print(adjacencyMatrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void shortestPath(int start, int destination) {
        int[] distance = new int[vertices];
        int[] parent = new int[vertices];
        boolean[] visited = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            visited[i] = false;
        }

        distance[start - 1] = 0;

        for (int i = 0; i < vertices; i++) {
            int u = minDistance(distance, visited);
            visited[u] = true;

            for (int v = 0; v < vertices; v++) {
                if (adjacencyMatrix[u][v] == 1 && !visited[v] && distance[u] + 1 < distance[v]) {
                    distance[v] = distance[u] + 1;
                    parent[v] = u;
                }
            }
        }

        System.out.println("Shortest Path:");
        printPath(parent, start, destination);
        System.out.println("Length: " + distance[destination - 1]);
    }

    private int minDistance(int[] distance, boolean[] visited) {
        int min = Integer.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < distance.length; i++) {
            if (!visited[i] && distance[i] < min) {
                min = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    private void printPath(int[] parent, int start, int destination) {
        if (destination == start) {
            System.out.print(start);
        } else {
            printPath(parent, start, parent[destination - 1]);
            System.out.print(" → " + destination);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        task3 = new task3(vertices);

        System.out.println("Enter the edges as (u, v) pairs:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        graph.displayAdjacencyMatrix();

        System.out.println("Enter the starting vertex:");
        int start = scanner.nextInt();
        System.out.println("Enter the destination vertex:");
        int destination = scanner.nextInt();

        graph.shortestPath(start, destination);
    }
}
}
