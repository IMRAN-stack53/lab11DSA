/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Mujtaba Abr
 */

    
    import java.util.Scanner;

public class task2 {

    private int vertices;
    private int[][] adjacencyMatrix;

    public task2(int vertices) {
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

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of vertices:");
        int vertices = scanner.nextInt();
        System.out.println("Enter the number of edges:");
        int edges = scanner.nextInt();

        task2 graph = new task2(vertices);

        System.out.println("Enter the edges as (u, v) pairs:");
        for (int i = 0; i < edges; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            graph.addEdge(u, v);
        }

        graph.displayAdjacencyMatrix();
    }
}

